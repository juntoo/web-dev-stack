const weeks = ["일", "월", "화", "수", "목", "금", "토"];
function setDate() {
  const now = new Date();
  const date = document.querySelector("#date");
  let week = weeks[now.getDay()];

  date.textContent = `${now.getFullYear()}년 ${
    now.getMonth() + 1
  }월 ${now.getDate()}일 (${week})`;
}

function setTime() {
  const now = new Date();
  const time = document.querySelector("#time");

  const hour = String(now.getHours()).padStart(2, "0");
  const min = String(now.getMinutes()).padStart(2, "0");
  const sec = String(now.getSeconds()).padStart(2, "0");
  time.textContent = `${hour}:${min}:${sec}`;
}

function setLeftTime() {
  const now = new Date();
  let nextYear = new Date(now.getFullYear() + 1, 0, 1, 0, 0, 0);

  const remaining = nextYear.getTime() - now.getTime();

  const leftSec = Math.floor((remaining / 1000) % 60); // 초
  const leftMin = Math.floor((remaining / 1000 / 60) % 60); // 분
  const leftHour = Math.floor((remaining / 1000 / 60 / 60) % 24); // 시간
  const leftDay = Math.floor(remaining / 1000 / 60 / 60 / 24); // 일

  leftTime.textContent = `올해 남은 시간 ${leftDay}일 ${String(
    leftHour
  ).padStart(2, "0")}시간 ${String(leftMin).padStart(2, "0")}분 ${String(
    leftSec
  ).padStart(2, "0")}초`;
}

function getRandColor() {
  const r = Math.floor(Math.random() * 256);
  const g = Math.floor(Math.random() * 256);
  const b = Math.floor(Math.random() * 256);

  return `rgba(${r}, ${g}, ${b}, ${0.3})`;
}

function changeColor() {
  const main = document.querySelector("#main");
  main.style.backgroundColor = getRandColor();
}

function randSaying() {
  const sayingEn = document.querySelector("#sayingEn");
  const sayingKo = document.querySelector("#sayingKo");

  const rand = Math.floor(Math.random() * 5);

  switch (rand) {
    case 0:
      sayingKo.textContent =
        "약간의 운동만 필요한 게 아니라면, 금이 있는 곳을 파라.";
      sayingEn.textContent =
        "Dig where the gold is unless you just need some exercise.";
      break;
    case 1:
      sayingKo.textContent = "낭비한 시간에 대한 후회는 더 큰 시간 낭비이다.";
      sayingEn.textContent = "Regret for wasted time is more wasted time.";
      break;
    case 2:
      sayingKo.textContent =
        "우리는 오늘은 이러고 있지만, 내일은 어떻게 될지 누가 알아요?";
      sayingEn.textContent = "We know what we are, but not what we may be.";
      break;
    case 3:
      sayingKo.textContent = "미래는 현재와 무척 닮았다. 단지 더 길뿐이다.";
      sayingEn.textContent =
        "The future is much like the present, only longer.";
      break;
    case 4:
      sayingKo.textContent = "시간은 인간이 쓸 수 있는 가장 값진 것이다.";
      sayingEn.textContent = "Time is the most valuable thing a man can spend.";
      break;
  }
}

setDate();
setTime();
setLeftTime();
changeColor();
randSaying();

setInterval(() => {
  changeColor(), randSaying();
}, 5000); // 배경색 변경, 랜덤 명언 : 5초
setInterval(() => {
  setDate(), setTime(), setLeftTime();
}, 1000); // 시간관련 : 1초
// setInterval(() => {
//   setTime();
// }, 1000);
// setInterval(() => {
//   leftTime.textContent = `내년까지 : ${setLeftTime()}`;
// }, 1000);
// setInterval(() => {
//   randSaying();
// }, 5000);
