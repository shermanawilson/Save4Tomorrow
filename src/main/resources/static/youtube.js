// const YOUTUBE_API_KEY = "AIzaSyAvK0vlvFQ_o11jqZ45-iFVaw_mCTY9H6Y";
// AIzaSyC3Q0K6kAG0qce-oA4DnCMtrth7fI1iuuc
console.log("hello world")
let playlistID
let nextPageToken =""

// function getVideos() {
    fetch("https://youtube.googleapis.com/youtube/v3/search?part=snippet&channelId=UCaL8K8g8y8K4_CvNuN0BDtg&maxResults=10&order=date&key=AIzaSyC3Q0K6kAG0qce-oA4DnCMtrth7fI1iuuc&pageToken=" +nextPageToken)
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
        <img id="youtube" src="${video.snippet.thumbnails.medium.url}">
        <h3>${video.snippet.title}</h3>
        </div>
        `
        }
    })
// }