$( document ).ready(function() {
    $('#zipcode').on('blur', validateZipcode);
    $("sform").submit(function(e){
        checkForm(e);
    });
});

var webServiceUrl='';
var zipvalid=false;

function wrongPerson(){
    var date = new Date();
    var curr = date.toString();

    document.cookie= "name=null;" + "expires" + curr;

    location.reload();
}

function computation(){
    var inputData = document.getElementById("dataBox").value;
    var tokens = inputData.split(",");
    if (tokens.length > 9){
        tokens = tokens.map((x) => parseInt(x, 10));
        var output = 0;
        var error = tokens.some((item) => item > 100 || item < 1 || isNaN(item))
        if (!error) {
            var arrAvg = tokens.reduce((a,b) => a + b, 0)
            var output = arrAvg / tokens.length
            var max = Math.max(...tokens)
            document.getElementById("outputAvr").value = output.toString();
            document.getElementById("outputMax").value = max.toString();
        } else {
            document.getElementById("outputMax").value = 'Your input is not valid';

            document.getElementById("outputAvr").value = 'Your input is not valid';
        }
        
    } else {
        document.getElementById("outputMax").value = 'Your input is not valid';
        document.getElementById("outputAvr").value = 'Your input is not valid';
    }
}

function checkForm(){
  let nosubmit=false;
  //check if the input contain only Alphabets
  var fullname = $('#fullname').val().split(' ').join('');
  var ifValidName = /^[A-Z]+$/i.test(fullname);
  if(!ifValidName) {
    nosubmit=true;
    window.alert("Error: Name contains invalid characters!");
    resetDom($('#fullname'));
  }
  //check if input address is valid
  const ifValidAddress = /^[0-9a-zA-Z]+$/.test($('#street').val().split(' ').join(''));
  if(!ifValidAddress) {
    nosubmit=true;
    window.alert("Error: Address contains invalid characters!");
    resetDom($('#street'));
  }
  //check if the email address is correct
  const emailValidation = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($('#email').val());
  if(!emailValidation){
    nosubmit=true;
    window.alert("Error: Please input a valid email address!");
    resetDom($('#email'));
  }
  //check if a radio button is selected
  if(document.querySelector('input[name="method"]:checked') == null) {
    nosubmit=true;
    window.alert("You need to choose an radio option!");
    resetDom($('[name ="method"]'));
    $('[name ="method"]').attr("checked",false);
  }
  //check if at least two checkbox are selected
  var boxes=document.getElementsByName("likeMost[]");
  var numofboxes=$('input[type="checkbox[]"]:checked').lentgh;
  var k=0;
  for (var i = 0; i <boxes.length; i++) {
    if (boxes[i].checked){
      k++;
    }
  }
  if (k<2) {
    nosubmit=true;
    window.alert("You need to choose at least two checkbox!");
    $('[name ="likeMost"]').attr("checked",false);
  }
  if(nosubmit){
    e.preventDefault();
  }
}

// function validateZipcode() {
//    const user_zipcode = $('#zipcode').val();
//    $.getJSON('zipcodes.json',function(data){
//        console.log(data);
//        const zipcode = data.zipcodes;
//        const zip_obj = {};
//        zipcode.forEach((item) => {
//            zip_obj[item.zip] = {
//                city: item.city,
//                state: item.state,
//            }
//        });
//        if(zip_obj[user_zipcode]) {
//            $('#city').text(zip_obj[user_zipcode].city);
//            $('#state').text(zip_obj[user_zipcode].state);
//            $('.zip_code_error').addClass('hide');
           
//        } else {
//            $('#city').text('');
//            $('#state').text('');
//            $('.zip_code_error').removeClass('hide');

//        }
//    }).fail(function (jqxhr, textStatus, error) {
//        var err = textStatus + ", " + error;
//        alert("There has been an error. If the problem persists contact the customer service");
//    });
// }

function resetDom(dom) {
    dom.val('');
}

function reset() {
    $('#fullname').val('');
    $('#street').val('');
    $('#email').val('');
    $('#date').val('');
    $('#city').text('');
    $('#state').text('');
    $('#url').val('');
    $('#phonenum').val('');
    $('#zipcode').val('');
    $('zip_code_error').addClass('hide');
}




