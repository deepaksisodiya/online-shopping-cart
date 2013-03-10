/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


var Category = {
    start: function(){
        this.initHTML();
        this.getCategoryFromServer();
        this.attachEvents();
        
    },
    deleteCategory: function(id){
        //http://localhost:8084/categoryList?opn=delete&categoryid=14
        var self = this;
        var selectedId = $(".categoryCheckBox:checked").val();
        if(selectedId === undefined){
            alert("Please Select");
        }else{
        $.ajax({
            url:"/categoryList?opn=delete&categoryid=" + selectedId,
            type:"GET",
            success: function(data){
                alert("Deleted");
            },
            error:function(){
                alert("Error");
            },
            contentType: "application/json",
            dataType:"json"

        });
        }

    },
    getCategoryFromServer: function(){
        var self = this;

        $.ajax({
            url:"/categoryview",
            type:"GET",
            success: function(data){
                self.renderData(data);
            },
            error:function(){
                alert("Error");
            },
            contentType: "application/json",
            dataType:"json"
         
        });
    },
    renderData: function(data){
        var str= '<table><tbody>\
                <tr><th>Select</th><th>id</th><th>name</th><th>details</th></tr>'
        $.each(data, function(i,v){
            str = str + '<tr><td><input class="categoryCheckBox" type="checkbox" name="categoryid" value="'+ v.id +'"></td><td>' + v.id + '</td><td>' + v.name + '</td><td>' + v.details + '</td></tr>';

        });
        str = str + '</tbody></table>';

        $("#categorytable").append(str);
    },
    initHTML: function(){
        $("#categoryView").append('<div>\
        <div id="categorytable"></div>\
        <div id="categoryadd">\
          <div>\
          <span>Name</span>\
          <input type="text" id="categogyaddName"></input>\
          </div>\
          <div>\
          <span>details</span>\
          <input type="text" id="categogyaddDetails"></input>\
          </div>\
          <input type="button" name="categoryname" value="save" id="categoryaddsave"></input>\
            <input type="button" name="categorydetails" value="cancel" id="categoryaddcancel"></input>\
        </div>\
        <div>\
            <input type="button" value="add" id="addcategory"></input>\
            <input type="button" value="edit" id="editcategory"></input>\
            <input type="button" value="delete" id="deleteategory"></input>\
        </div>\
        </div>');
        this.showTable();

    },
    attachEvents: function(){
        var self = this;
        $("#addcategory").click(
        function(){
            $("#categorytable").hide();
            $("#categoryadd").show();
        });

        $("#categoryaddcancel").click(
        function(){
            self.showTable();
        });
        $("#categoryaddsave").click(
        function(){
            self.addCategory();
        });
        $("#deleteategory").click(
        function(){
            self.deleteCategory();
        });
    },
    addCategory: function(){
        //
        var self = this;

//        var reqObj = {
//            categoryname : $("#categogyaddName").val(),
//            categorydetails: $("#categogyaddDetails").val()
//        };
        var str = "categoryname=" + $("#categogyaddName").val() + "&categorydetails=" + $("#categogyaddDetails").val();
        
        
        $.ajax({
            url:"/categoryList?opn=add",
            type:"POST",
            data: str,
            success: function(data){
               alert("Added");
               self.showTable();
            },
            error:function(){
                alert("Error");
            },
            contentType: "application/x-www-form-urlencoded",
            dataType:"json"

        });
    },
    showTable: function(){
         $("#categorytable").show();
          $("#categoryadd").hide();

    }




};

