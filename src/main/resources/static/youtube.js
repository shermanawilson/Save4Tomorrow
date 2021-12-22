// const YOUTUBE_API_KEY = "AIzaSyDcmQAqWFeD_Uoc9boc3X2kGpRDjO5uwTE";
console.log("hello world")
let playlistID
let nextPageToken =""

// function getVideos() {
    fetch("https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=UCqP6K5GNGvQXSI10xNIAkxA&maxResults=50&order=date&key=https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=UCqP6K5GNGvQXSI10xNIAkxA&maxResults=50&order=date&key=AIzaSyDcmQAqWFeD_Uoc9boc3X2kGpRDjO5uwTE&pageToken=" +nextPageToken)
        .then((result) => {
            return result.json()
        }).then((data) => {
        console.log(data)
        let videos = data.items
        nextPageToken = data.nextPageToken
        let videoContainer = document.querySelector(".youtubeVideos")
        for (video of videos) {
            console.log(video.snippet.title)
            videoContainer.innerHTML += `
        <div id="youtubeContainer">
        <img id="youtube" src="${video.snippet.thumbnails.default.url}">
        <h3>${video.snippet.title}</h3>
        </div>
        `
        }
    })
// }