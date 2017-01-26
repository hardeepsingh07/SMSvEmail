/**
 * Created by hardeepsingh on 1/25/17.
 */
function sendEmail() {
    $('#send').prop("disabled", true);
    var number = $('#number').val();
    var provider = $('#selection').val();
    var subject = $('#subject').val();
    var message = $('#message').val();

    //alert("JQuery: " + number + provider + message + subject);
    if (number && provider && message) {
        $.ajax(
            {
                type : "POST",
                url  : "/sendemail/" + number,
                data : {
                    "provider" : provider,
                    "subject"  : subject,
                    "message"  : message
                },
                success : function(result) {
                    if(result === 'error') {
                        $('#send').prop("disabled", false);
                        alert("Error: Please information and try again.")
                    } else {
                        //Reset fields
                        $('#number').val("");
                        $('#subject').val("");
                        $('#message').val("");

                        //Show success alert
                        alert("Text successfully sent to " + number);
                        $('#send').prop("disabled", false);
                    }
                },
                error: function (jqXHR, exception) {
                    alert("Failed to send text. Try again later");
                }
            });
    } else {
        alert("Input fields required");
    }
}