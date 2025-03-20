
let submitBtn = document.querySelector('.mySubmit');
let myForm = document.getElementById('form');
let myIcon = document.querySelector('.ic');
submitBtn.addEventListener('click', (event) => {
  event.preventDefault();
  myIcon.classList.add('load');
  setTimeout(() => {
     myIcon.classList.add('rotate');
     myIcon.innerHTML = '<span class="material-symbols-outlined">progress_activity</span>';
  },600);
  setTimeout(() => {
     myForm.submit();
   } , 5000);
});

