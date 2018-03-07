function calculateData() {
    $("#table").find("tr.foodTr").each(function () {
        var value = $(this).find(".value").html();
        var cal = $(this).find(".cal").html();
        var proteins = $(this).find(".protein").html();
        var fats = $(this).find(".fats").html();
        var starches = $(this).find(".starches").html();

        $(this).find(".fats").html((fats / 100) * value);
        $(this).find(".starches").html((starches / 100) * value);
        $(this).find(".protein").html((proteins / 100) * value);
        $(this).find(".cal").html((cal / 100) * value);
    });
    return this;
}

function testAlert() {
    var message = $("#testDiv").html();
    alert("test successful" + message);
}

