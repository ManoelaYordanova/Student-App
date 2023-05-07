<template>
  <body>
  <div class="frontPage">
  <video autoplay loop muted playsinline class="back-video">
    <source src="../assets/video.mp4" type="video/mp4">
  </video>

    <div class="text">
    <h1>ENJOY YOUR YOUTH</h1>
    </div>
  </div>
  </body>
</template>

<script>
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  font-family: "Book Antiqua";
  box-sizing: border-box;
}

body {
  display: flex;
  justify-content: center;
  align-items: center;
}
.back-video {
  position: absolute;
  right: 0;
  bottom: 0;
  z-index: 0;
}

@media (min-aspect-ratio: 16/9) {
  .back-video {
    width: 100%;
    height: auto;
  }
}

@media (max-aspect-ratio: 16/9) {
  .back-video {
    width: auto;
    height: 100%;
  }
}

.text h1{
  color: white;
  text-shadow: #2c3e50 2px 5px;
  position: relative;
  top: 120px;
  right: 380px;
  font-size: 60px;
  font-style: italic;
  z-index: 1;
}
</style>
