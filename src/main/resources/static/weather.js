const WEATHER_API_KEY = "af490826bd781f8c6df4775c5164833f";
const KELVIN = 273
let currentWeather = document.querySelector("#currentWeather")
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
        currentWeather.innerHTML = `${weather.temperature.value}°F`;
        weather.temperature.unit = "fahrenheit"
    } else{
        currentWeather.innerHTML = `${weather.temperature.value}°C`;
        weather.temperature.unit = "celsius"
    }
})