// Feedback Module javascript for feedback submission 


$j(document).ready(function() {
    	$j('#dialog').dialog({
	autoOpen: false,
	modal: true			
    });
});

function test() {
    	$j('#dialog').dialog({
            autoOpen: true,
	    width: '90%'
	});
}