window.onload = function () {
    fetch("https://api.giphy.com/v1/gifs/trending?api_key=w9K2wwtQMEsfNl9B3FvC7SckuwWQ3hlZ&limit=25&offset=0&rating=g&bundle=messaging_non_clips")
        .then( function(respuesta) {
            return respuesta.json();
        })
        .then( function(informacion) {
            console.log(informacion.data);

            for(let i = 0; i < informacion.data.length; i++) {
                let gif = `<p>${informacion.data[i].title}</p>`;
                gif += `<img src="${informacion.data[i].images.original.url}" >`;
                document.querySelector('ul').innerHTML += `<li>${gif}</li>`;
            }
        })
        .catch(function(e) {
            alert("Error! Intente mas tarde" + e);
        })
}