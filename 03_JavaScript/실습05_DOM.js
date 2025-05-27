const now = new Date();

let dayTrans;
if (now.getDay() == 1) dayTrans = "월";
if (now.getDay() == 2) dayTrans = "화";

const date = document.querySelector("#date");
const time = document.querySelector("#time");

function setDate() {
  date.textContent = `${now.getFullYear()}년 ${
    now.getMonth() + 1
  }월 ${now.getDate()}일 (${dayTrans})`;
  time.textContent = `${now.getHours()}:${now.getMinutes()}:${now.getSeconds()}`;
}

setInterval(() => {
  setDate();
}, 100);

// function randBack() {
//   randR = Math.floor(Math.random() * 256);
//   randG = Math.floor(Math.random() * 256);
//   randB = Math.floor(Math.random() * 256);
// }
