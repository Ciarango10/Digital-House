import { useState } from 'react'
import './App.css'

function App() {
  const [likesProgramming, setLikesProgramming] = useState(false);
  const [programmingLanguages, setProgrammingLanguages] = useState('');
  const [message, setMessage] = useState('');

  const handleLikesProgramming = (e) => { 
    setLikesProgramming(e.target.checked);
    setMessage('');
  }

  const handleProgrammingLanguages = (e) => {
    setProgrammingLanguages(e.target.value);
    setMessage('');
  };

  const handleSubmit = (e) => { 
    e.preventDefault();

    if (likesProgramming) {
      if (programmingLanguages.trim().length > 0) {
        setMessage(`Te gustan los siguientes lenguajes de programación: ${programmingLanguages}`);
      } else {
        setMessage('La pregunta es obligatoria');
      }
    } else {
      setMessage('Que lástima =( ');
    }
  }

  return (
    <>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="chkLenguajes">¿Le gustan los lenguajes de programación?</label>
          <input 
            type="checkbox" 
            name="chkLenguajes" 
            id="chkLenguajes" 
            checked={likesProgramming} 
            onChange={handleLikesProgramming} 
          />
        </div>
        {likesProgramming ? (
          <div>
            <label htmlFor="txtLenguajes">Ingrese los lenguajes de programación que le gustan</label>
            <input 
              type="text" 
              id='txtLenguajes' 
              value={programmingLanguages} 
              name='txtLenguajes' 
              onChange={handleProgrammingLanguages} 
            />
          </div>
        ):null}
        <button>Enviar</button>
      </form>
      {message && (
        <h4 style={{ color: message === 'La pregunta es obligatoria' ? 'red' : 'white' }}>
          {message}
        </h4>
      )}
    </>
  )
}

export default App
