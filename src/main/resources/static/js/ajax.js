$(document).ready(function () {

    $("#kullaniciForm").submit(function (event) {

        event.preventDefault();

        var kullaniciForm = {}
        kullaniciForm["ad"] = $("#ad").val();
        kullaniciForm["soyad"] = $("#soyad").val();

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/kullanici",
            data: JSON.stringify(kullaniciForm),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "Ajax Cevap"
                    + JSON.stringify(data, null, 4);
                $('#feedback').html(json);

            },
            error: function (e) {

                var json = "Ajax Hata"
                    + e.responseText;
                $('#feedback').html(json);


            }
        });

    });

});
