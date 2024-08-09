import { useState } from "react"

export const Rejuvenecedor = () => {
    const [nombre, setNombre] = useState("");
    const [edad, setEdad] = useState(0);

    const onChangeNombre = (e) => setNombre(e.target.value);
    const onChangeEdad = (e) => setEdad(e.target.value);

    const validateNombre = () => {
        const withoutSpaces = nombre.trim();

        //Separamos el nombre en un arreglo para iterarlo y verificar que no haya numeros
        const nombreAsArray = withoutSpaces.split("");

        //Some nos retorna true si al menos una de las iteraciones es verdadera
        const hasNumber = nombreAsArray.some((letra) => {
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

    const validateEdad = () => {

        if(edad > 0) {
            return true;
        }
        return false;
    }

    const onSubmitForm = (e) =>  {
        e.preventDefault();

        if(!validateNombre()) {
            alert("El nombre debe tener minimo 1 caracter y no debe contener numeros");
            return;
        } 
        if(!validateEdad()) {
            alert("La edad debe mayor a 0");
            return;
        }
        setEdad(edad-10)
        alert(`${nombre}, su nueva edad es: ${edad-10}`);
    }

  return (
    <form onSubmit={onSubmitForm}>
        <label htmlFor="txtNombre">Nombre</label>
        <input type="text" id="txtNombre" onChange={onChangeNombre} value={nombre}/>
        <label htmlFor="txtEdad">Edad</label>
        <input type="number" id="txtEdad" onChange={onChangeEdad} value={edad}/>
        <button type="submit">Rejuvenecer</button>
    </form>
  )
}
