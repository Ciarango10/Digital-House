import { useState } from 'react'
import './App.css'
import Pedido from './Components/Pedido';

function App() {

  const [toggle, setToggle] = useState(true);

  return (
    <>
      Su pedido: 
      {toggle && <Pedido />}
      <button onClick={() => setToggle(false)}>Cancelar Pedido</button>
    </>
  )
}

export default App
