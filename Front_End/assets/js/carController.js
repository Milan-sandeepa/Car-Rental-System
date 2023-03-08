let baseUrlCar = "http://localhost:8080/Car_Rental_System_war/";

getAllCars();

generateCarId();

//Add Car
$("#carAddBtn").click(function () {

    // let formData = $("#carAddForm").serialize();
    let formData = new FormData();

    let regNo = $("#txtRegNo").val();
    let carModel = $("#txtCarModel").val();
    let carType = $("#txtCarType").val();
    let transmission = $("#txtTransmission").val();
    let fuelType = $("#txtFuelType").val();
    let carColor = $("#txtCarColor").val();
    let passengers = $("#txtPassenger").val();
    let lossDamage = $("#txtLossDamage").val();
    let dailyRate = $("#txtDailyRate").val();
    let monthlyRate = $("#txtMonthlyRate").val();
    let extraKm = $("#txtExtraKm").val();

    formData.append("regNo",regNo);
    formData.append("carModel",carModel);
    formData.append("carType",carType);
    formData.append("carTransmission",transmission);
    formData.append("fuelType",fuelType);
    formData.append("carColor",carColor);
    formData.append("passenger",passengers);
    formData.append("lossDamage",lossDamage);
    formData.append("dailyRate",dailyRate);
    formData.append("monthlyRate",monthlyRate);
    formData.append("extraKm",extraKm);
    //
    let file1 = $("#CarImage")[0].files[0];
    let fileName1 = $("#CarImage")[0].files[0].name;

    formData.append("carImage",file1,fileName1);

    $.ajax({
        url: baseUrlCar + "car",
        method: "post",
        data: formData,
        dataType: "json",
        async: true,
        contentType: false,
        processData: false,
        enctype:"multipart/form-data",
        success: function (res) {
            // invoked if the response status code is in 200 range
            console.log("Success Method Invoked")
            console.log(res);
            alert(res.message);
            getAllCars();

        },
        error: function (error) {
            // invokes if status code range is 500 range or 400 range
            console.log("Error Method Invoked");
            console.log(JSON.parse(error.responseText));
            alert(JSON.parse(error.responseText).message);
        }
    });
});

//Get all Cars Function
function getAllCars() {
    console.log("success load");
    $("#tblCar").empty();
    $.ajax({
        url: baseUrlCar+"car",
        success: function (res) {
            console.log(res);
            for (let c of res.data) {
                let regNo = c.regNo;
                let carModel = c.carModel;
                let carType = c.carType;
                let carTransmission = c.carTransmission;
                let fuelType = c.fuelType;
                let carColor = c.carColor;
                let passenger = c.passenger;
                let lossDamage = c.lossDamage;
                let dailyRate = c.dailyRate;
                let monthlyRate = c.monthlyRate;
                let extraKm = c.extraKm;
                let carImage = c.carImageUrl;
                let available = c.available;
                let status = c.status;

                let row = `<tr>

                        <td class="regNoID">${regNo}</td>
                        <td>${carModel}</td>
                        <td>${carType}</td>
                        <td>${carTransmission}</td>
                        <td>${fuelType}</td>
                        <td>${carColor}</td>
                        <td>${passenger}</td>
                        <td>${lossDamage}</td>
                        <td>${dailyRate}</td>
                        <td>${monthlyRate}</td>
                        <td>${extraKm}</td>
                        <td><img src="${baseUrlCar + carImage}" width="100px"></td>
                        <td>${available}</td>
                        <td>${status}</td>

             <td><i class="editIconCar fa-solid fa-pen-to-square" data-bs-toggle="modal"data-bs-target="#carEditModal"></i>
                 <i class="deleteIconCar fa-solid fa-trash" style="margin-left: 10px"></i></td>

                        </tr>`;



                $("#tblCar").append(row);
            }
            bindRowClickCarEvents();
            // setTextFieldValues("", "", "", "");
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
}


function bindRowClickCarEvents() {
    $(".editIconCar").click(function () {

        // Find the row
        var row = $(this).closest("tr");

        // Find the text
        var searchID = row.find(".regNoID").text();

        console.log(searchID)
        if (searchID!=null){
            $.ajax({
                url: baseUrlCar+"car",
                success: function (res) {
                    for (let c of res.data) {
                    console.log(c)
                        if (c.regNo == searchID) {
                            $('#txtUpdateRegNo').val(c.regNo);
                            $('#txtUpdateCarModel').val(c.carModel);
                            $('#txtUpdateCarType').val(c.carType);
                            $('#txtUpdateTransmission').val(c.carTransmission);
                            $('#txtUpdateFuelType').val(c.fuelType);
                            $('#txtUpdateCarColor').val(c.carColor);
                            $('#txtUpdatePassenger').val(c.passenger);
                            $('#txtUpdateLossDamage').val(c.lossDamage);
                            $('#txtUpdateDailyRate').val(c.dailyRate);
                            $('#txtUpdateMonthlyRate').val(c.monthlyRate);
                            $('#txtUpdateExtraKm').val(c.extraKm);
                        }
                    }
                },
                error: function (error) {
                    let message = JSON.parse(error.responseText).message;
                    alert(message);
                }
            });

        }else {
            alert("No such Car to edit. please try Again");
        }
    });

    $(".deleteIconCar").click(function () {

        // Find the row
        var row = $(this).closest("tr");

        // Find the text
        var id = row.find(".regNoID").text();

        let option = confirm("Do you really want to delete Car regNo :" + id);

        if (option){
            $.ajax({
                url: baseUrlCar+"car?id=" + id,
                method: "delete",
                success: function (resp) {
                    getAllCars();
                    alert(resp.message);
                },
                error: function (error) {
                    let message = JSON.parse(error.responseText).message;
                    alert(message);
                }
            });
        }
    });
}

$("#carAddUpdateBtn").click(function () {
    let res = confirm("Do you want to add this Update Car.?");
    if (res) {

        let regNo =$('#txtUpdateRegNo').val();
        let carModel =$('#txtUpdateCarModel').val();
        let carType =$('#txtUpdateCarType').val();
        let carTransmission =$('#txtUpdateTransmission').val();
        let fuelType =$('#txtUpdateFuelType').val();
        let carColor =$('#txtUpdateCarColor').val();
        let passenger =$('#txtUpdatePassenger').val();
        let lossDamage =$('#txtUpdateLossDamage').val();
        let dailyRate =$('#txtUpdateDailyRate').val();
        let monthlyRate =$('#txtUpdateMonthlyRate').val();
        let extraKm =$('#txtUpdateExtraKm').val();


        var carOb = {
            regNo: regNo,
            carModel: carModel,
            carType: carType,
            carTransmission: carTransmission,
            fuelType: fuelType,
            carColor: carColor,
            passenger: passenger,
            lossDamage: lossDamage,
            dailyRate: dailyRate,
            monthlyRate: monthlyRate,
            extraKm: extraKm
        }

        $.ajax({
            url: baseUrlCar+"car",
            method: "put",
            contentType: "application/json",
            data: JSON.stringify(carOb),
            dataType: "json",
            success: function (resp) {
                getAllCars();
                alert(resp.message);
            },
            error: function (error) {
                let message = JSON.parse(error.responseText).message;
                alert(message);
            }
        });

    }else {
        alert("Update Failed..!");
    }
});

function generateCarId() {

    $.ajax({
        url: baseUrlCar + "car/gererateId",
        method:"get",
        dataType: "json",
        success: function (res) {
            $("#txtRegNo").val(res.data);
        },
        error:function (error){
            alert(JSON.parse(error.responseText).message);
        }
    });
}

// car seach bar
$(document).ready(function (){
    $("#searchCarInput").on('keyup',function (){
        var value = $(this).val().toLowerCase();

        $("#tblCar>tr").filter(function (){
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
        });
    });
});