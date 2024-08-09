import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [show, setShow] = useState(false);
  const [user, setUser] = useState({
    name: "",
    age: 0,
    pokemon: ""
  })

  const handleChangeName = (e) => {
    setUser({...user, name: e.target.value});
  }

  const handleChangeAge = (e) => {
    setUser({...user, age: e.target.value});
  }

  const handleChangePokemon = (e) => {
    setUser({...user, pokemon: e.target.value});
  }

  const validateAge = () => {
    if(user.age > 0) {
        return true;
    }
    return false;
  }

  const validatePokemon = () => {
    if(user.pokemon.trim().length > 3) {
        return true;
    }
    return false;
  }

  const validateName = () => {
    const withoutSpaces = user.name.trim();

    //Separamos el nombre en un arreglo para iterarlo y verificar que no haya numeros
    const nameAsArray = withoutSpaces.split("");

    //Some nos retorna true si al menos una de las iteraciones es verdadera
    const hasNumber = nameAsArray.some((letra) => {
        if(isNaN(letra)) {
            return false;
        }
        return true;
    })
    
    if(!hasNumber && withoutSpaces.length > 0) {
        return true;
    }

    return false;
}

  const handleSubmit = (e) => {
    e.preventDefault();

    if(validateName() && validateAge() && validatePokemon()) {
      setShow(true);
    } else {
      alert("Alguno de los campos ingresados está con el formato incorrecto");
    }
  }

  const reset = () => {
    setUser({
      name: "",
      age: 0,
      pokemon: ""
    })
  }

  return (
    <>
      {show ? (
        <h4>Fomulario ingresado con éxito</h4>
      ) : (
        <form onSubmit={handleSubmit}>
          <label htmlFor="txtNombreCompleto">Nombre Completo</label>
          <input type="text" id="txtNombreCompleto" value={user.name} onChange={handleChangeName}/>
          <label htmlFor="txtEdad">Edad</label>
          <input type="number" id='txtEdad' value={user.age} onChange={handleChangeAge}/>
          <label htmlFor="txtPokemonFavorito">Pokemon Favorito</label>
          <input type="text" id='txtPokemonFavorito' value={user.pokemon} onChange={handleChangePokemon}/>
          <button type='submit'>Registro</button>
          <button onClick={reset}>Reset</button>
        </form>
      )}
    </>
  )
}

export default App
