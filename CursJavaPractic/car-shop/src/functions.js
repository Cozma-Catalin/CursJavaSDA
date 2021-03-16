
function processRegistrationForm(){
    
    var brandValue = document.forms["registration_form"]["brand"].value;
    var modelValue = document.forms["registration_form"]["model"].value;
    var productionYearValue = document.forms["registration_form"]["productionYear"].value;
    var registrationYearValue = document.forms["registration_form"]['registrationYear'].value;
    var colorValue = document.forms["registration_form"]["color"].value;
    var fuelTypeValue = document.forms["registration_form"]["fuelType"].value;
    var kmValue = document.forms["registration_form"]["km"].value;
    var priceValue = document.forms["registration_form"]["price"].value;
    var crashedValue = document.forms["registration_form"]["crashed"].value;

    console.log(brandValue);
    console.log(modelValue);
    console.log(productionYearValue);
    console.log(registrationYearValue);
    console.log(colorValue);
    console.log(fuelTypeValue);
    console.log(kmValue);
    console.log(priceValue);
    console.log(crashedValue);
    console.log('Process completed !');

}

function processSellingForm(){

    var nameValue = document.forms['selling_form']['name'].value;
    var surnameValue = document.forms['selling_form']['surname'].value;
    var cityValue = document.forms['selling_form']['city'].value;
    var ageValue = document.forms['selling_form']['age'].value;
    var priceValue = document.forms['selling_form']['price'].value;
    var leasingValue = document.forms['selling_form']['leasing'].value;
    var emailValue = document.forms['selling_form']['email'].value;
    var phoneNumberValue = document.forms['selling_form']['phoneNumber'].value;
    var dateValue = document.forms['selling_form']['date'].value;

    console.log(nameValue);
    console.log(surnameValue);
    console.log(cityValue);
    console.log(ageValue);
    console.log(priceValue);
    console.log(leasingValue);
    console.log(emailValue);
    console.log(phoneNumberValue);
    console.log(dateValue);
    console.log('Process completed !');

}
