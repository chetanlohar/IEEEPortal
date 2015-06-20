<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enquiry form</title>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> 
<script type=text/javascript>

	$(function(){
		
		$('#getdata').click(function(){
			
			var names = [];
			var email = [];
			var cntno = [];
			
			alert("hiii")
			alert($('#enqDate').val())
			//alert($('#name').val())
			names.push($('#name').val());
			for(i=1;i<=4;i++){
				
				if($('#name' + i).val()){
					//name.push($('#name' + i).val());
					
					names.push($('#name' + i).val());
					alert($('#name' + i).val());
				}
			}
		    alert(names);
			
			for(i=1;i<4;i++){
				
				if($('#email' + i).val()){
					email.push($('#email' + i).val()); 
				}
			}
		
			
			for(i=1;i<4;i++){
				
				if($('#cntno' + i).val()){
					cntno.push($('#cntno' + i).val()); 
				}
			}	
						
			$.ajax({
				
				url:'StudentEnquiryController',
				type:'post',
				datatype:'json',
				data :{
						enquirydata: JSON.stringify({
						"enDate":$('#enqDate').val(),
						"enCity" : $('#enqCity').val(),
						"enCollege":$('#enqCollege').val(),
						"enDept" : $('#enqDept').val(),
						"enDomain" : $('#enqDomain').val(),
						"enTech" : $('#enqTech').val(),
						"enTeamSz" : $('#enqTeamSz').val(),
						"enName" : names,	
						"enEmail" : email,	
						"encntno" : cntno			
					})
					
				},
				success:function(){
					alert($('#enqDate').val())
				}
			});
			
		});
	});

</script>
<script type="text/javascript">
$(function() {
    var scntDiv = $('#cont');
    var i = $('#cont p').size() + 1;
    
    $('.addcontact1').live('click', function() {
        $('<p><input type="text" id="name' + i +'"  required size="20" name="name' + i +'" /><a href="#" id="remScnt"><input type="button" value="-"></a><input type="button" class="addcontact1" value="+"/></p>').appendTo(scntDiv);
        i++; 
           $(this).hide();
          
          
    });
    
    $('#remScnt').live('click', function() { 
            if( i > 2 ) {
                    $(this).closest('p').remove();
                   
                   i--;
                  
            }
            
            $('#cont p').last().find('.addcontact1').show();
            return false;             
    });
   
});
</script>






</head>
<body>


<!-- <form action ="StudentEnquiryController" method = "get"> -->
	Enquiry Date :<input type="text" id="enqDate"><br>
	city :<input type="text" id="enqCity"><br>
	college:<input type = "text" id="enqCollege"><br>
	dept:<input type="text" id="enqDept"><br>
	domain:<input type="text" id="enqDomain"><br>
	technology:<input type="text" id="enqTech"><br>
	Team Size:<input type="text" id="enqTeamSz"><br>
	<div id="cont">
		<p>
			<label>Name: </label> <input type="text" id="name" />
			<input class="addcontact1" type="button" value="+" />
		</p>
	</div>
	email:<input type="text" id="email"><br>
	contact no:<input type="text" id="cntno"><br>
	

   <input type="button" id="getdata" value ="submit">
   <!-- </form> -->


</body>
</html>