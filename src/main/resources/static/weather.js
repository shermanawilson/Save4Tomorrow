const WEATHER_API_KEY = "af490826bd781f8c6df4775c5164833f";
const KELVIN = 273
let currentWeather = document.querySelector("#currentWeather")
let todayEntry = document.querySelector("#todayEntry")
const notificationElement = document.querySelector("#notification")
const weather = {}

weather.temperature = {
    unit: "celsius"
}

function getWeather(latitude, longitude) {
    let api = `https://api.openweathermap.org/data/2.5/weather?lat=${latitude}&lon=${longitude}&appid=${WEATHER_API_KEY}`;
    fetch(api)
        .then((result) => {
            return result.json()
        }).then((data) => {
        console.log(data)
        weather.temperature.value = Math.floor(data.main.temp - KELVIN);
    }).then(() => {
        displayWeather();
    })
}

todayEntry.innerHTML = `$${weather.temperature.value}`
// if(todayEntry == null) {displayWeather()}

if ('geolocation' in navigator) {
    navigator.geolocation.getCurrentPosition(setPosition, showError);
} else {
    notificationElement.style.display = "block";
    notificationElement.innerHTML = "<p>Browser doesn't support Geolocation</p>";
}

function setPosition(position) {
    let latitude = position.coords.latitude;
    let longitude = position.coords.longitude;

    getWeather(latitude, longitude);
}

function showError(error) {
    notificationElement.style.display = "block";
    notificationElement.innerHTML = `<p> ${error.message} </p>`;
}

function displayWeather() {
    currentWeather.innerHTML = `${weather.temperature.value}°C`
}

function celsiusToFahrenheit(temperature) {
    return (temperature * 9 / 5) + 32;
}

currentWeather.addEventListener("click", function () {
    if (weather.temperature.value === undefined) return;

    if (weather.temperature.unit == "celsius") {
        let fahrenheit = celsiusToFahrenheit(weather.temperature.value);
        fahrenheit = Math.floor(fahrenheit);
        currentWeather.innerHTML = `${fahrenheit}°F`;
        weather.temperature.unit = "fahrenheit"
    } else {
        currentWeather.innerHTML = `${weather.temperature.value}°C`;
        weather.temperature.unit = "celsius"
    }
})

let fahrenheit = celsiusToFahrenheit(weather.temperature.value);
fahrenheit = Math.floor(fahrenheit);
todayEntry.innerHTML = `Click To See`;

todayEntry.addEventListener("click", function () {
    if (weather.temperature.value === undefined) return;

    if (weather.temperature.unit == "celsius") {
        let fahrenheit = celsiusToFahrenheit(weather.temperature.value);
        fahrenheit = Math.floor(fahrenheit);
        todayEntry.innerHTML = `$${fahrenheit}`;
        weather.temperature.unit = "fahrenheit"
    }
})

let date = new Date();
let da = new Intl.DateTimeFormat('en', {day: '2-digit'}).format(date);
let mo = new Intl.DateTimeFormat('en', {month: 'short'}).format(date);
let ye = new Intl.DateTimeFormat('en', {year: 'numeric'}).format(date);
const dateText = document.querySelector("#theDate");
dateText.innerHTML = `${mo}-${da}-${ye}`;


// Bingo Javascript
// let total = "";
// let tiles = document.querySelector(".bingoTile");
// let totalArray = [
//     [52, 52, 52, 52, 52],
//     [52, 52, 52, 52, 52],
//     [52, 52, 0, 52, 52],
//     [52, 52, 52, 52, 52],
//     [52, 52, 52, 52, 52]
//     ]
// function bingoTotal() {
//     const tile1 = document.querySelector("#1");
//     if(tiles == tile1.innerHTML.valueOf()){
//         tile1.style.backgroundColor = "green"
//     }
// }