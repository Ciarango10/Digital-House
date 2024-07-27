import './App.css'
import Componente from './Componente'

function App() {
  let juegos = ['Fortnite', 'Valorant', 'FIFA', 'COD'];
  const JuegosLista = () => {
    return juegos.map( (juego) => {
      return <li key={juego}>{juego}</li>
    });
  }
  return (
    
    <>
      <h1>Bienvenidos a Vite</h1>
      <h2>Lista de juegos</h2>
      <ul>
        {JuegosLista()}
      </ul>
      <Componente/>
    </>
  )
}

export default App
