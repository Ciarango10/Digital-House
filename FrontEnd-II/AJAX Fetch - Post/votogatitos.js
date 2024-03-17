window.onload = function() {
    let data = {
        image_id : "asf2",
        sub_id : "my-user-1234",
        value : 1
    }

    let settings = {
        method: "POST",
        headers: { 
            "Content-Type": "application/json",
            "x-api-key": "89d0ffa5-5d01-42d0-b830-ab273474edad"
        },
        body: JSON.stringify(data)
    }

    fetch("https://api.thecatapi.com/v1/votes", settings)
        .then(function(response) {
            return response.json();
        })
        .then(function(info) {
            console.log(info);
        })
        .catch(function (e) {
            console.log("Error: " + e);
        });
}