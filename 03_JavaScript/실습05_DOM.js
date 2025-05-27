function setDate() {
  const now = new Date();
  const date = document.querySelector("#date");
  let dayTrans = "";
  if (now.getDay() == 1) dayTrans = "월";
  if (now.getDay() == 2) dayTrans = "화";
  if (now.getDay() == 3) dayTrans = "수";
  if (now.getDay() == 4) dayTrans = "목";
  if (now.getDay() == 5) dayTrans = "금";
  if (now.getDay() == 6) dayTrans = "토";
  if (now.getDay() == 0) dayTrans = "일";

  date.textContent = `${now.getFullYear()}년 ${
    now.getMonth() + 1
  }월 ${now.getDate()}일 (${dayTrans})`;
}

function setTime() {
  const now = new Date();
  const time = document.querySelector("#time");
  time.textContent = `${now.getHours()}:${now.getMinutes()}:${now.getSeconds()}`;
  //console.log(`${now.getHours()}:${now.getMinutes()}:${now.getSeconds()}`);
}

function setLeftTime() {
  const now = new Date();

  let nextYear = new Date(now.getFullYear() + 1, 1, 1, 0, 0, 0);

  const remaining = nextYear.getTime() - now.getTime();

  const leftSec = Math.floor((remaining / 1000) % 60);
  const leftMin = Math.floor((remaining / 1000 / 60) % 60);
  const leftHour = Math.floor((remaining / 1000 / 60 / 60) % 24);
  const leftDay = Math.floor(remaining / 1000 / 60 / 60 / 24);

  return `${leftDay}일 ${leftHour}시간 ${leftMin}분 ${leftSec}초 남음`;
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
  const saying = document.querySelector("#saying");

  const rand = Math.floor(Math.random() * 5);

  switch (rand) {
    case 0:
      saying.textContent =
        '"이른 아침은 입에 황금을 물고 있다." -벤자민 프랭클린';
      break;
    case 1:
      saying.textContent =
        '"미래를 예측하는 최선의 방법은 미래를 창조하는 것이다." -알랜 케이';
      break;
    case 2:
      saying.textContent =
        '"곧은 것은 한결같이 속인다. 진리는 하나같이 굽어 있으며, 시간 자체도 둥근 고리다." -프레드리히 니체';
      break;
    case 3:
      saying.textContent =
        '"시간 엄수는 비즈니스의 영혼이다." -토마스 할리버튼';
      break;
    case 4:
      saying.textContent =
        '"나는 당신에게 러시아의 행동을 예측해줄 수 없소. 그것은 불가사의 속의 미스터리로 포장된 수수께끼요. 그렇지만 아마 답은 있을 거요. 그 답은 러시아의 국익이오." -윈스턴 처칠';
      break;
  }
}

const leftTime = document.querySelector("#leftTime");

setInterval(() => {
  changeColor();
}, 5000);
setInterval(() => {
  setDate();
}, 1000);
setInterval(() => {
  setTime();
}, 1000);
setInterval(() => {
  leftTime.textContent = `내년까지 : ${setLeftTime()}`;
}, 1000);
setInterval(() => {
  randSaying();
}, 5000);
