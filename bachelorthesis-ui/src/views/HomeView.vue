<template>
  <body>
  <section class="home">
    <video class="video-slide active" src="../assets/video.mp4" autoplay muted loop></video>
    <video class="video-slide" src="../assets/video2.mp4" autoplay muted loop></video>
    <video class="video-slide" src="../assets/video3.mp4" autoplay muted loop></video>
    <div class="content active">
      <h1>Be with friends.<br><span>Be happy</span></h1>
      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's
        standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make
        a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting,
        remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing
        Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions
        of Lorem Ipsum.</p>
    </div>
    <div class="content">
      <h1>Go Camping.<br><span>Enjoy it</span></h1>
      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's
        standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make
        a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting,
        remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing
        Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions
        of Lorem Ipsum.</p>
    </div>
    <div class="content">
      <h1>Run.<br><span>Be active</span></h1>
      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's
        standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make
        a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting,
        remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing
        Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions
        of Lorem Ipsum.</p>
    </div>
    <div class="media-icons">
      <a href="#"> <i class="fa-brands fa-facebook"></i> </a>
      <a href="#"> <i class="fa-brands fa-instagram"></i> </a>
      <a href="#"> <i class="fa-brands fa-twitter"></i> </a>
    </div>
    <div class="slider-navigation">
      <div class="nav-btn"></div>
      <div class="nav-btn"></div>
      <div class="nav-btn"></div>
    </div>
  </section>
  </body>
</template>

<script>
export default {
  name: 'HomeView',
  components: {},
  mounted () {
    const btns = document.querySelectorAll('.nav-btn')
    const slides = document.querySelectorAll('.video-slide')
    const contents = document.querySelectorAll('.content')

    console.log(btns)
    if (btns) {
      var sliderNav = function (manual) {
        btns.forEach((btn) => {
          btn.classList.remove('active')
        })

        slides.forEach((slide) => {
          slide.classList.remove('active')
        })

        contents.forEach((content) => {
          content.classList.remove('active')
        })

        btns[manual].classList.add('active')
        slides[manual].classList.add('active')
        contents[manual].classList.add('active')
      }

      btns.forEach((btn, i) => {
        btn.addEventListener('click', () => {
          sliderNav(i)
        })
      })
    }
  }
}
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  font-family: "Book Antiqua";
  box-sizing: border-box;
}

section {
  padding: 100px 200px;
}

.home {
  position: relative;
  bottom: 0px;
  width: 100%;
  min-height: 100vh;
  display: flex;
  justify-content: center;
  flex-direction: column;
  background: #cde0ec;
}

.home .content {
  z-index: 888;
  color: #fff;
  width: 70%;
  margin-top: 50px;
  display: none;
  position: relative;
  top: 100px;
  right: 150px;
}

.home .content.active {
  display: block;
}
.home .content h1 {
  font-size: 3em;
  font-weight: 700;
  text-transform: uppercase;
  letter-spacing: 5px;
  line-height: 75px;
  margin-bottom: 40px;
}

.home .content h1 span {
  font-size: 0.7em;
  font-weight: 300;
}

.home .content p {
  margin-bottom: 65px;
  font-size: 18px;
}

.home .media-icons {
  z-index: 888;
  position: absolute;
  bottom: 40px;
  right: 30px;
  display: flex;
  flex-direction: column;
  transition: 0.5s ease;
}

.home .media-icons a {
  color: #cde0ec;
  font-size: 2em;
}

.home .media-icons a:not(:last-child) {
  margin-bottom: 20px;
}

.home .media-icons a:hover {
  transform: scale(1.3);
}

.home video {
  z-index: 000;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.slider-navigation {
  z-index: 888;
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  transform: translateY(80px);
  margin-bottom: -10px;
}

.slider-navigation .nav-btn {
  width: 15px;
  height: 15px;
  background: #fff;
  border-radius: 50%;
  cursor: pointer;
  box-shadow: 0 0 2px rgba(255, 255, 255, 0.5);
  transition: 0.3s ease;
}

.slider-navigation .nav-btn:not(:last-child) {
  margin-right: 20px;
}

.slider-navigation .nav-btn:hover {
  transform: scale(1.2);
}

.slider-navigation .nav-btn.active {
  background: #cde0ec;
}
.video-slide {
  position: absolute;
  width: 100%;
  clip-path: circle(0% at 0 50%);
}
.video-slide.active {
  clip-path: circle(150% at 0 50%);
  transition: 1s ease;
  transition-property: clip-path;
}
</style>
