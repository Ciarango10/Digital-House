import { useState } from 'react'
import './App.css'
import CardStyles from './Styles/App.module.css'

function App() {
  const [darkMode, setDarkMode] = useState(false);

  const handleDarkMode = () => setDarkMode(!darkMode);
  return (
    <>
      <button onClick={handleDarkMode}>🌓</button>
      <div className={darkMode ? CardStyles.darkCard : CardStyles.card} style={{marginTop:10}}>
        <img src="https://via.placeholder.com/100" alt="Avatar" />
        <h1>¡Hola!</h1>
        <p>Esta es una tarjeta de ejemplo</p>
      </div>
    </>
  )
}

export default App
