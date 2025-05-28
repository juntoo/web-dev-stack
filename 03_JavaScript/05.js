const weeks = ["일", "월", "화", "수", "목", "금", "토"];
const today = new Date();
const year = today.getFullYear();
const month = today.getMonth() + 1;
const day = today.getDate();
const week = weeks[today.getDay()];

const current = document.querySelector("#current");
//console.log(current);
current.textContent = `${year}년 ${month}월 ${day}일 (${week})`;

const clock = document.querySelector("#clock");
const hour = today.getHours();
const min = today.getMinutes();
const sec = today.getSeconds();

clock.textContent = `${hour}:${min}:${sec}`;

const currentTime = () => {
  const weeks = ["일", "월", "화", "수", "목", "금", "토"];
  const today = new Date();
  const year = today.getFullYear();
  const month = today.getMonth() + 1;
  const day = today.getDate();
  const week = weeks[today.getDay()];

  const current = document.querySelector("#current");
  //console.log(current);
  current.textContent = `${year}년 ${month}월 ${day}일 (${week})`;

  const clock = document.querySelector("#clock");
  const hour = String(today.getHours()).padStart(2, "0");
  const min = String(today.getMinutes()).padStart(2, "0");
  const sec = String(today.getSeconds()).padStart(2, "0");

  clock.textContent = `${hour}:${min}:${sec}`;
};

const randBackground = () => {
  const body = document.body;

  //   const backGround = [
  //     "#ED833A",
  //     "#EA839B",
  //     "#42B667",
  //     "#FFC228",
  //     "#005456",
  //     "#ACDED5",
  //   ];

  //   body.style.background =
  //     backGround[Math.floor(Math.random() * backGround.length)];

  const r = Math.floor(Math.random() * 256);
  const g = Math.floor(Math.random() * 256);
  const b = Math.floor(Math.random() * 256);

  body.style.background = `rgba(${r},${g},${b},${0.3})`;
};

const count = () => {
  const count = document.querySelector("#count");
  const last = new Date("2026-01-01 00:00:00");
  const now = new Date();

  const remainingTime = last - now;

  const sec = Math.floor(remainingTime / 1000);
  const min = Math.floor(sec / 60);
  const hour = Math.floor(min / 60);
  const day = Math.floor(hour / 24);

  const remainingSec = String((sec % 60) + 1).padStart(2, "0");
  const remainingMin = String(min % 60).padStart(2, "0");
  const remainingHour = String(hour % 24).padStart(2, "0");

  count.textContent = `올해 남은 시간 ${day}일 ${remainingHour}시간 ${remainingMin}분 ${remainingSec}초`;
};

import quotes from "./quotes.js";

const randQuote = () => {
  const quoteEn = document.querySelector("#quoteEn");
  const quoteKo = document.querySelector("#quoteKo");

  const random = quotes[Math.floor(Math.random() * quotes.length)];

  quoteEn.textContent = `${random.en}`;
  quoteKo.textContent = `${random.ko}`;
};

currentTime();
randBackground();
count();
randQuote();

setInterval(() => {
  currentTime(), count();
}, 1000);

setInterval(() => {
  randBackground(), randQuote();
}, 5000);
