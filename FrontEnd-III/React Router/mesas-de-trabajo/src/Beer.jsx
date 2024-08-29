import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from "react-router-dom";

//Esta pagina renderizará cada bebida de manera individual

const Beer = () => {
    const navigate = useNavigate();
    const params = useParams();
    const [beer, setBeer] = useState([])

    const getBeer = async()=>{
        //Deberas completar este fetch con el parametro correspondiente
        const res = await fetch(`https://api.sampleapis.com/beers/ale/${params.id}`)
        const data = await res.json()
        setBeer(data)
    }

    useEffect(()=>{
        getBeer()
    }, [])
  
  return (
    <div>
        <h2>Cerveza numero...</h2>
        <div className='card'>
            <img src={beer.image} alt="beer-detail" />
            <p>{beer.name}</p>
            <p>{beer.price} </p>
        </div>
        <button onClick={() => navigate(-1)}>Go back</button>
    </div>

  )
}

export default Beer