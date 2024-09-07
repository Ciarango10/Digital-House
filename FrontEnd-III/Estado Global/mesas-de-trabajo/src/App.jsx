import './App.css'
import React, { useState } from 'react'
import LanguageContext, { languages } from './context';
import Navbar from './components/Navbar';
import Body from './components/Body';

function App() {

  const [language, setLanguage] = useState(languages.english);

  const handleChangeLA = () => {
    setLanguage((prevLanguage) => {
      //SUGERENCIA: Función que cambia de un idioma a otro (haciendo clic en el botón)
      if (prevLanguage === languages.english) return languages.spanish;
      if (prevLanguage === languages.spanish) return languages.portuguese;
      if (prevLanguage === languages.portuguese) return languages.english;
    })
  }

  return (
    <div className="App">
    {/* Proveedor de LanguageContext con el idioma actual y la función de cambio */}
    <LanguageContext.Provider value={{ language, handleChangeLA }}>
      <Navbar />
      <Body />
    </LanguageContext.Provider>
  </div>
  )
}

export default App