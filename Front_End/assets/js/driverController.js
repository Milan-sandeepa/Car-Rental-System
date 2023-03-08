let baseUrlDriver="http://localhost:8080/Car_Rental_System_war/";

getAllDrivers();
generateDriverId();

//Add Driver
$("#driverAddBtn").click(function () {
    let formData = $("#driverAddForm").serialize();
    $.ajax({
        url: baseUrlDriver+"driver",
        method: "post",
        data: formData,
        dataType: "json",
        success: function (res) {
            // invoked if the response status code is in 200 range
            console.log("Success Method Invoked")
            console.log(res);
            alert(res.message);
            getAllDrivers();
        },
        error: function (error) {
            // invokes if status code range is 500 range or 400 range
            console.log("Error Method Invoked");
            console.log(JSON.parse(error.responseText));
            alert(JSON.parse(error.responseText).message);

        }
    });

});

// Get all Driver Function
function getAllDrivers() {
    $("#tblDriver").empty();
    $.ajax({
        url: baseUrlDriver+"driver",
        success: function (res) {
            for (let c of res.data) {
                let driverID = c.driverID;
                let name = c.name;
                let licenseNo = c.licenseNo;
                let address = c.address;
                let gender = c.gender;
                let contact = c.contact;
                let email = c.email;
                let password = c.password;

                let row = `<tr>

                        <td class="driverID">${driverID}</td>
                        <td class="name">${name}</td>
                        <td>${licenseNo}</td>
                        <td>${address}</td>
                        <td>${gender}</td>
                        <td >${contact}</td>
                        <td >${email}</td>
                        <td><i class="editIconDriver fa-solid fa-pen-to-square" data-bs-toggle="modal"data-bs-target="#driverEditModal"></i>
                        <i class="deleteIconDriver fa-solid fa-trash" style="margin-left: 10px"></i></td>

                        </tr>`;

                $("#tblDriver").append(row);
            }
            bindRowClickDriverEvents();
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
}

function bindRowClickDriverEvents() {
    $(".editIconDriver").click(function () {

        // Find the row
        var row = $(this).closest("tr");

        // Find the text
        var searchID = row.find(".driverID").text();


        if (searchID!=null){
            $.ajax({
                url: baseUrlDriver+"driver",
                success: function (res) {
                    for (let c of res.data) {

                        if (c.driverID == searchID) {
                            $('#txtUpdateDriverId').val(c.driverID);
                            $('#txtUpdateDriverName').val(c.name);
                            $('#txtUpdateDriverLicenseNo').val(c.licenseNo);
                            $('#txtUpdateDriverAddress').val(c.address);
                            $('#txtUpdateDriverGender').val(c.gender);
                            $('#txtUpdateDriverContact').val(c.contact);
                            $('#txtUpdateDriverEmail').val(c.email);
                            // $('#txtUpdateUserConPwd').val(c.userPwd);
                        }
                    }
                },
                error: function (error) {
                    let message = JSON.parse(error.responseText).message;
                    alert(message);
                }
            });



        }else {
            alert("No such Driver to edit. please try Again");
        }

        var searchName = row.find(".name").text();
        if (searchID!=null){
            $.ajax({
                url: baseUrl+"user",
                success: function (res) {
                    for (let c of res.data) {
                        console.log(c)
                        if (c.username == searchName) {
                            $('#txtUpdateDriverPass').val(c.password);
                        }
                    }
                },
                error: function (error) {
                    let message = JSON.parse(error.responseText).message;
                    alert(message);
                }
            });



        }else {
            alert("No such driver to edit. please try Again");
        }

    });

    $(".deleteIconDriver").click(function () {

        // Find the row
        var row = $(this).closest("tr");

        // Find the text
        var id = row.find(".driverID").text();

        let option = confirm("Do you really want to delete Driver Id :" + id);

        if (option){
            $.ajax({
                url: baseUrlDriver+"driver?id=" + id,
                method: "delete",
                success: function (resp) {
                    getAllDrivers();
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

$("#driverUpdateBtn").click(function () {
    let res = confirm("Do you want to add this Update Driver.?");
    if (res) {

        let driverID =$('#txtUpdateDriverId').val();
        let name =$('#txtUpdateDriverName').val();
        let licenseNo =$('#txtUpdateDriverLicenseNo').val();
        let address =$('#txtUpdateDriverAddress').val();
        let gender =$('#txtUpdateDriverGender').val();
        let contact =$('#txtUpdateDriverContact').val();
        let email =$('#txtUpdateDriverEmail').val();
        let password =$('#txtUpdateDriverPass').val();


        var driverOb = {
            driverID: driverID,
            name: name,
            licenseNo: licenseNo,
            address: address,
            gender: gender,
            contact: contact,
            email: email,
            password: password,
        }

        $.ajax({
            url: baseUrlDriver+"driver",
            method: "put",
            contentType: "application/json",
            data: JSON.stringify(driverOb),
            dataType: "json",
            success: function (resp) {
                getAllDrivers();
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

function generateDriverId() {
    $.ajax({
        url: baseUrlCar + "driver/gererateId",
        method:"get",
        dataType: "json",
        success: function (res) {
            $("#txtDriverId").val(res.data);
        },
        error:function (error){
            alert(JSON.parse(error.responseText).message);
        }
    });
}