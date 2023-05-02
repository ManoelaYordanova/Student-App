<template>
  <header>
    <h2 class="logo">Student Events</h2>
    <nav class="navigation">
      <a href="#">Home</a>
      <a href="#">Events</a>
      <a href="#">About</a>
      <button class="btnLogin-popup">Login</button>
    </nav>
  </header>

  <div class="upperPage">
  <div class="grid-container">
    <div class="grid-item-1">
      <h1>100 College Event Ideas for Students on Campus [2023]</h1>
    </div>
    <div class="grid-item-2">
      <p>Are you looking to host college events that students will actually want to attend? A fun campus event attracts a crowd and engages students. These college event ideas listed below can also help build school spirit and camaraderie among your student body.

        Check out these 100 college event ideas that are perfect for any campus!

        This post may contain affiliate links. If you make a purchase, GenTwenty may receive a commission at no additional cost to you. Thank you for supporting this resource.</p>
    </div>
    <div class="grid-item-3">
      <div class="card">
        <div class="imgBx">
          <img src="../assets/trivia-night.png">
        </div>
        <div class="content">
          <h2>Trivia Night</h2>
          <p>Trivia nights are always popular and they are a great way to get students engaged. You can either do this on your own or team up with another campus organization.</p>
        </div>
      </div>

      <div class="card">
        <div class="imgBx">
          <img src="../assets/movie-night.jpg">
        </div>
        <div class="content">
          <h2>Have a movie night</h2>
          <p>A classic movie night is always a hit with students. Be sure to choose movies that everyone will enjoy.</p>
        </div>
      </div>

      <div class="card">
        <div class="imgBx">
          <img src="../assets/food-drive.jpg">
        </div>
        <div class="content">
          <h2>Host a food drive</h2>
          <p>Food drives are always important, and they’re a great way to get students involved. You could partner with a local charity or organization. University life is about fun and learning, and what better way to help that mission than with community events that give back?</p>
        </div>
      </div>
    </div>
  </div>
  </div>

  <div class="middlePage">
    <h2>fdgdg</h2>
  </div>
</template>
<style>
*{
  font-family: "Book Antiqua";
}
.upperPage{
  background: url("../assets/6843558.jpg");
  background-size: cover;
  background-position: center;
  height: 710px;
  margin-top: -10px;
}
.grid-container{
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-template-rows: repeat(2, 1fr);
  margin-top: 130px;
  height: 583px;
}
.grid-item-1{
  grid-column-start: 1;
  grid-column-end: 1;
  grid-row-start: 1;
  grid-row-end: 1;
  margin-top: 40px;
  margin-left: 100px;
  padding-top: 30px;
  font-size: 20px;
  text-align: center;
  color: #045467;
}
.grid-item-1 h1 {
  font-weight: 600;
  text-shadow: #fff 2px 3px;
}
.grid-item-2{
  grid-column-start: 2;
  grid-column-end: 4;
  grid-row-start: 1;
  grid-row-end: 1;
  margin-left: 80px;
  margin-right: 50px;
  padding-top: 30px;
  font-size: 20px;
  color: black;
  text-align: start;
  align-content: center;
  background-color: #fff;
  border-radius: 20px;
  opacity: 0.4;
  position: relative;
  top: 40px;
  height: 230px;
}
.grid-item-3{
  grid-column-start: 1;
  grid-column-end: 4;
  grid-row-start: 2;
  grid-row-end: 2;
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-wrap: wrap;
  padding: 30px;
}
.grid-item-3 .card{
  position: relative;
  max-width: 370px;
  height: 170px;
  background: #fff;
  margin: 30px 10px;
  padding: 20px 15px;
  display: flex;
  flex-direction: column;
  box-shadow: 0 5px 20px rgba(0,0,0,0.5);
  transition: 0.3s ease-in-out;
  border-radius: 20px;
}
.grid-item-3 .card:hover{
  height: 360px;
}
.grid-item-3 .card .imgBx{
  position: relative;
  width: 320px;
  height: 200px;
  top: -60px;
  left: 20px;
  z-index: 1;
  box-shadow: 0 5px 20px rgba(0,0,0,0.2);
  border-radius: 20px;
}
.grid-item-3 .card .imgBx img{
  width: 320px;
  height: 200px;
  border-radius: 20px;
}
.grid-item-3 .card .content{
  position: relative;
  margin-top: -140px;
  padding: 10px 15px;
  text-align: center;
  color: #111;
  visibility: hidden;
  opacity: 0;
  transition: 0.3s ease-in-out;
}
.grid-item-3 .card:hover .content{
  visibility: visible;
  opacity: 1;
  margin-top: -55px;
  transition-delay: 0.4s;
}
header{
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  z-index: 99;
}
.logo{
  margin-left: 50px;
  font-size: 2em;
  color: black;
  user-select: none;
}
.navigation a{
  position: relative;
  font-size: 1.5em;
  color: black;
  text-decoration: none;
  font-weight: 500;
  margin-left: 40px;
}
.navigation a::after{
  content: '';
  position: absolute;
  left: 0;
  bottom: -6px;
  width: 100%;
  height: 3px;
  background: black;
  border-radius: 5px;
  transform-origin: right;
  transform: scaleX(0);
  transition: transform .5s;
}
.navigation a:hover::after{
  transform-origin: left;
  transform: scaleX(1);
}
.navigation .btnLogin-popup{
  width: 130px;
  height: 50px;
  background: transparent;
  border: 2px solid black;
  outline: none;
  border-radius: 6px;
  cursor: pointer;
  font-size: 1.1em;
  color: black;
  font-weight: 500;
  margin-left: 40px;
  transition: .5s;
}
.navigation .btnLogin-popup:hover{
  background: #42b983;
  color: #fff;
}
</style>
<script setup>

</script>
