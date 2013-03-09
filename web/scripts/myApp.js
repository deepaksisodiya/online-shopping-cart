$(function(){
	//$("#firstDiv1").append("<h1>this is bad</h1>");
        //alert("aasd");
        $.ajax({
            url:"/categoryview",
            dataType:"json",
            success:function(data){

                //alert(data);
                var str = "<table><tr><td>id</td><td>name</td><td>details</td></tr>";
                for(var i=0;i<data.length;i++){
                    str = str + "<tr><td>"+data[i].id+"</td><td>"+ data[i].name+"</td><td>"+ data[i].details+"</td></tr>"
                    
                }
                 str = str + "</table>";
              $("#firstDiv1").append(str);
            }

           

        });

        $("#firstDiv1").click(function(){
            alert("i am clicked");
            //$(this).hide()

        });

});
