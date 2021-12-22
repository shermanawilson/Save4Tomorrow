// const WEATHER_API_KEY = "af490826bd781f8c6df4775c5164833f\n";
console.log("Hello World")
fetch("https://api.openweathermap.org/data/2.5/weather?q=dallas&appid=af490826bd781f8c6df4775c5164833f")
    .then((result) => {
        return result.json()
    }).then((data) => {
    console.log(data)
    let currentWeather = document.querySelector("#currentWeather")
    currentWeather.innerHTML += `
    <h1>°</h1>
    `
})