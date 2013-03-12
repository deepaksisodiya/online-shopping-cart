/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


var Register = {
    start: function(){
        this.initHTML();
    },

    initHTML: function(){
        $("#register").append('<div>\
        <div id="registerid">\
          <div>\
          <span>Username</span>\
          <input type="text" id="uname"></input>\
          </div>\
          <div>\
          <span>Password</span>\
          <input type="text" id="pass"></input>\
          </div>\
          <div>\
          <span>Name</span>\
          <input type="text" id="name"></input>\
          </div>\
          <div>\
          <span>Address</span>\
          <input type="text" id="address"></input>\
          </div>\
          <div>\
          <span>Phone</span>\
          <input type="text" id="phone"></input>\
          </div>\
          <div>\
          <span>Email</span>\
          <input type="text" id="email"></input>\
          </div>\
          <input type="button" name="register" value="register" id="register"></input>\
        </div>\
        </div>');

        this.showTable();

    },
    attachEvents: function(){
        var self = this;
        $("#register").click(
        function(){
            $("#loginid").hide();
            self.register();
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


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


