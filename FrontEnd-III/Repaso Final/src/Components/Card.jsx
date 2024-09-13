import React from "react";
import { Link } from "react-router-dom";
import { useCharStates } from "../Context";

const Card = ({ char }) => {
  const { state, dispatch } = useCharStates();
  const isFav = state.favs.find((fav) => fav.id === char.id);
  console.log(isFav);
  const addFav = () => {
    dispatch({ type: isFav ? "REMOVE_FAV" : "ADD_FAV", payload: char });
    // setFavs((favs) => [...favs, char]);
    // if (isFav) {
    //   dispatch({ type: "REMOVE_FAV", payload: char });
    // } else {
    //   dispatch({ type: "ADD_FAV", payload: char });
    // }
  };

  return (
    <div>
      <img src={char.image} alt="" />
      <Link to={"/detail/" + char.id}>
        <h2>{char.name}</h2>
      </Link>
      <button onClick={addFav}>{isFav ? "🌟" : "⭐"}</button>
    </div>
  );
};

export default Card;
