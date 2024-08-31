import React, { useState } from 'react'

const Form = ({handleClick}) => {

    const [error, setError] = useState('');

    const handleChange = (e) => {
        if (!isNaN(e.target.value)) {
            setError('El input no admite valores numéricos');
        } else {
            setError('');
        }
    }

  return (
    <div>
        <input type="text" data-testid="input" onChange={handleChange}/>
        {error && <p>{error}</p>}
        <button onClick={handleClick}>Enviar</button>
    </div>
  )
}

export default Form