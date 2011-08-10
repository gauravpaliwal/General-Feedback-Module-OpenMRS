// Feedback Module javascript for feedback submission 


$j(document).ready(function() {
    	$j('#dialog').dialog({
	autoOpen: false,
	modal: true			
    });
    	$j('#feedbackPhotoDialog').dialog({
	autoOpen: false,
	modal: true			
    });
});

function popUp() {
    	$j('#dialog').dialog({
            autoOpen: true,
	    width: '90%'
	});

}

function fdbkPhotoPopUp() {
    	$j('#feedbackPhotoDialog').dialog({
            autoOpen: true,
	    width: '90%'
	});

}