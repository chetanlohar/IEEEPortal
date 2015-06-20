<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="resources_ui/js/jquery.min.js"></script>
	<script type="text/javascript"
	src="resources_ui/js/jquery-1.10.2.js"></script>
<script type="text/javascript"
	src="resources_ui/js/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript"
	src="resources_ui/js/jquery-ui-1.10.4.custom.js"></script>
<title>Insert title here</title>
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
	<div id="cont">
		<p>
			<label>Name: </label> <input type="text" name="name" id="name" />
			<input class="addcontact1" type="button" value="+" />
		</p>
	</div>
</body>
</html>