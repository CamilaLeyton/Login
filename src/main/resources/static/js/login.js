// Obtener referencias a los elementos del DOM
const registerButton = document.getElementById('registerButton');
const loginButton = document.getElementById('loginButton');
const container = document.getElementById('container');

// Agregar eventos de clic a los botones
registerButton.addEventListener('click', () => {
  container.classList.add('right-panel-active');  // agrega una clase y esa clase mueve el div hacia un lado usando css
});

loginButton.addEventListener('click', () => {
  container.classList.remove('right-panel-active'); // le quita la clase y mueve el div a su posicion original 
});
