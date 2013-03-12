/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


var Product = {
    start: function(){
        this.initHTML();
        this.getProductFromServer();
        this.attachEvents();

    },
    
    
    
    getProductFromServer: function(){
        var self = this;

        $.ajax({
            url:"/productView",
            type:"GET",
            success: function(data){
                self.productList = data;
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
                <tr><th>Select</th><th>productname</th><th>productprice</th><th>stockinhand</th></tr>'
        $.each(data, function(i,v){
            str = str + '<tr><td><input class="productCheckBox" type="checkbox" name="productid" value="'+ v.id +'"></td><td>' + v.productname + '</td><td>' + v.productprice + '</td><td>' + v.stockinhand + '</td></tr>';

        });
        str = str + '</tbody></table>';

        $("#producttable").append(str);
    },
    initHTML: function(){
        $("#productViewH").append('<div>\
        <div id="producttable"></div>\
        <div>\
            <input type="button" value="add to cart" id="addcart"></input>\
            <input type="button" value="remove from cart" id="removecart"></input>\
        </div>\
        </div>');

        this.showTable();

    },
    attachEvents: function(){
        var self = this;
        $("#addcart").click(
        function(){
            self.mode = "add";
            $("#producttable").hide();
            $("#").show();
        });

        $("#productaddcancel").click(
        function(){
            self.showTable();
        });
        $("#productaddsave").click(
        function(){
            self.addProduct();
        });

        $("#deleteproduct").click(
        function(){
            self.deleteProduct();
        });

        $("#editproduct").click(
        function(){

            var selectedId = $(".productCheckBox:checked").val();
            if(selectedId === undefined){
                alert("Please Select");
            }else{
                self.mode = "update";
                $("#producttable").hide();
                $("#productadd").show();
                self.fillData(selectedId);
            }

        });


    },
    fillData: function(selectedId){

        $.each(this.productList, function(i,v){
            if(v.id === selectedId){
                $("#productaddName").val(v.productname);
                $("#categoryaddID").val(v.categoryid);
                $("#productaddPrice").val(v.productprice);
                $("#productaddStock").val(v.stockinhand);
                $("#productaddDangerlevel").val(v.dangerlevel);
                $("#productaddID").val(v.id);

            }
        });
    },
    addProduct: function(){
        //
        var self = this;
        var str = "categoryid=" + $("#categoryaddID").val() + "&productname=" + $("#productaddName").val() + "&productprice=" + $("#productaddPrice").val() + "&stockinhand=" + $("#productaddStock").val() + "&dangerlevel=" + $("#productaddDangerlevel").val();
        var url = "";
        switch(self.mode){
            case "add":
                url = "/productList?opn=add";
                break;
            case "update":
                url = "/productList?opn=update";
                str = str + "&productid=" + $("#productaddID").val();
                break;

        }

        $.ajax({
            url:url,
            type:"POST",
            data: str,
            success: function(data){
               alert("Done");
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
         $("#producttable").show();
         $("#productadd").hide();
    }

};


