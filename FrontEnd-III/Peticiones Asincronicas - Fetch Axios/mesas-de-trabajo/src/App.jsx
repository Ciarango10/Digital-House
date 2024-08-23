import { useEffect, useState } from 'react'
import './App.css'
import Card from './Components/Card'

function App() {
  const [pokemons, setPokemons] = useState({})
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    let allPokemons = [];
    const fetchData = async () => {
      for(let i=1; i <= 6; i++) {
        let response = await fetch(`https://pokeapi.co/api/v2/pokemon/${i}`);
        let data = await response.json();
        allPokemons.push(data);
      }
    }
    setPokemons(allPokemons);

    setTimeout(() => {
      setLoading(false);
    }, 2000);

    fetchData();
  }, []);

  return (
    <>
      {loading ? "Cargando..." : 
      <div className="list-container">
        {pokemons.map((pokemon) => {
          return <Card key={pokemon.id} pokemon={pokemon}></Card>
        })}
      </div>
      }
    </>
  )
}

export default App
