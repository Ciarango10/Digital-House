/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, { enumerable: true, get: getter });
/******/ 		}
/******/ 	};
/******/
/******/ 	// define __esModule on exports
/******/ 	__webpack_require__.r = function(exports) {
/******/ 		if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 			Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 		}
/******/ 		Object.defineProperty(exports, '__esModule', { value: true });
/******/ 	};
/******/
/******/ 	// create a fake namespace object
/******/ 	// mode & 1: value is a module id, require it
/******/ 	// mode & 2: merge all properties of value into the ns
/******/ 	// mode & 4: return value when already ns object
/******/ 	// mode & 8|1: behave like require
/******/ 	__webpack_require__.t = function(value, mode) {
/******/ 		if(mode & 1) value = __webpack_require__(value);
/******/ 		if(mode & 8) return value;
/******/ 		if((mode & 4) && typeof value === 'object' && value && value.__esModule) return value;
/******/ 		var ns = Object.create(null);
/******/ 		__webpack_require__.r(ns);
/******/ 		Object.defineProperty(ns, 'default', { enumerable: true, value: value });
/******/ 		if(mode & 2 && typeof value != 'string') for(var key in value) __webpack_require__.d(ns, key, function(key) { return value[key]; }.bind(null, key));
/******/ 		return ns;
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = "./app.js");
/******/ })
/************************************************************************/
/******/ ({

/***/ "./app.js":
/*!****************!*\
  !*** ./app.js ***!
  \****************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

eval("const { generateText, validateInput } = __webpack_require__(/*! ./util */ \"./util.js\");\n\ncreateElement = (type, text, className) => {\n  // Crea y retorna un nuevo elemento HTML\n  const newElement = document.createElement(type);\n  newElement.classList.add(className);\n  newElement.textContent = text;\n  return newElement;\n};\n\nconst initApp = () => {\n  // Permite inicializar el aplicativo\n  // y tiene un \"listener\" para cuando se le de click al botón \"Agregar estudiante\"\n  const newUserButton = document.querySelector('#btnAddUser');\n  newUserButton.addEventListener('click', addUser);\n};\n\nconst addUser = () => {\n  //Se crea un nuevo elemento HTML en el DOM cada vez que se agregue un estudiante\n  const newUserNameInput = document.querySelector('input#name');\n  const newUserAgeInput = document.querySelector('input#age');\n  const newUserLevelInput = document.querySelector('#userLevel');\n\n  if (\n    !validateInput(newUserNameInput.value, true, false) ||\n    !validateInput(newUserAgeInput.value, false, true)\n  ) {\n    return;\n  }\n\n  const userList = document.querySelector('.user-list');\n  const outputText = generateText(\n    newUserNameInput.value,\n    newUserAgeInput.value,\n    newUserLevelInput.value,\n  );\n  const element = createElement('li', outputText, 'user-item');\n  userList.appendChild(element);\n};\n\n// Inicializa el aplicativo\ninitApp();\n\n//# sourceURL=webpack:///./app.js?");

/***/ }),

/***/ "./util.js":
/*!*****************!*\
  !*** ./util.js ***!
  \*****************/
/*! no static exports found */
/***/ (function(module, exports) {

eval("exports.generateText = (name, age, level) => {\n  // Se crea un objeto con los datos del registro y se retorna un mensaje con el estado del registro\n  if(age >= 18 && age <= 65) {\n    student = {\n      \"name\": name,\n      \"age\": true,\n      \"level\": level\n    }; \n    return `Registro OK de ${student.name} en: ${student.level}.`;\n  }\n  if(age>65) {\n    student = {\n      \"name\": name,\n      \"age\": false,\n      \"level\": null\n    }; \n    return `No pudimos registrar a: ${student.name}. Por favor contactá a soporte@dh.com para más información.`;\n  }\n  return `Edad ingresada no válida. Por favor intentá nuevamente.`\n};\n\nexports.validateInput = (text, notEmpty) => {\n  //Valida la entrada de datos en los inputs\n  if (!text) {\n    return false;\n  }\n  if (notEmpty && text.trim().length === 0) {\n    return false;\n  }\n  return true;\n};\n\n//# sourceURL=webpack:///./util.js?");

/***/ })

/******/ });