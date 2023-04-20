<template>
  <body>
  <header>
    <div class="logo">
      <p>Student Events</p>
    </div>
    <nav>
      <ui>
        <li><a href = "#">Home</a></li>
        <li><a href = "#">Events</a></li>
        <li><a href = "#">Just announced</a></li>
        <li><a href = "#">About</a></li>
      </ui>
    </nav>
    <button><a href = "#">Log In</a></button>
  </header>
  <div class="text">
    <h1>ENJOY YOUR YOUTH</h1>
  </div>
  <div class="grid-container">
    <div class="grid-item-1">
      <h1>100 College Event Ideas for Students on Campus [2023]</h1>
    </div>
    <div class="grid-item-2">
      <p>Are you looking to host college events that students will actually want to attend? A fun campus event attracts a crowd and engages students. These college event ideas listed below can also help build school spirit and camaraderie among your student body.

        Check out these 100 college event ideas that are perfect for any campus!

        This post may contain affiliate links. If you make a purchase, GenTwenty may receive a commission at no additional cost to you. Thank you for supporting this resource.</p>
    </div>
  </div>
  <div class="flex-container">
    <img src="../assets/4.jpg" class="card-img">
    <img src="../assets/5.jpg" class="card-img">
    <img src="../assets/6.jpg" class="card-img">
  </div>
  </body>
</template>

<script>
// @ is an alias to /src

</script>
<style scoped>
*{
  margin: 0;
  padding: 0;
  font-family: "Book Antiqua";
  box-sizing: border-box;
}
body{
  background-image: url("../assets/2.jpg");
  background-repeat: no-repeat;
  background-size: auto;
  height: 60vh;
}
header{
  width: 100%;
  height: 100px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 30px 10%;
  background: rgba(0,0,0,0.3);
}
.logo{
  font-size: 45px;
  font-weight: bold;
  color: #fff;
  letter-spacing: 2px;
  cursor: pointer;
}
nav li{
  display: inline-block;
  list-style: none;
  padding: 0px 20px;
}
a, button{
  font-size: 23px;
  font-weight: 500;
  color: #fff;
  text-decoration: none;
  cursor: pointer;
}
button{
  background: rgba(0,0,0,0.2);
  border: 3px solid #fd5e53;
  border-radius: 50px;
  padding: 9px 25px;
}
nav li a:hover{
  color: #fd5e53;
  transition: all 0.4s ease 0s;
  text-decoration: underline #fd5e53;
}
button:hover{
  background-color: #fd5e53;
  transition: all 0.4s ease 0s;
}
.text{
  color: white;
  text-shadow: #fd5e53 2px 5px;
  margin-top: 100px;
  font-size: 40px;
  font-style: italic;
}
.grid-container{
  display: grid;
  grid-template-columns: 1fr 2fr;
  background-color: darkturquoise;
  margin-top: 130px;
  height: 350px;
}
.grid-item-1, .grid-item-2{
  width: auto;
  height: 160px;
  margin-top: 70px;
  margin-left: 170px;
  font-size: 20px;
  text-align: center;
  color: aliceblue;
}
.grid-item-2{
  margin-right: 50px;
  border-left: 4px inset blue;
}
.flex-container{
  width: 500px;
  height: 300px;
  display: block;
}
.card-img{
  width: 100px;
  height: 200px;
}

</style>
