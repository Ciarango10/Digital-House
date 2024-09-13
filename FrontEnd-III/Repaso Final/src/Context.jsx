import axios from "axios";
import { createContext, useContext, useEffect, useReducer } from "react";
import { reducer } from "./reducers/reducer";

const CharStates = createContext();
const lsFavs = JSON.parse(localStorage.getItem("favs")) || [];

const initialState = {
  list: [],
  favs: lsFavs,
  theme: true,
};

const Context = ({ children }) => {
  // const [theme, setTheme] = useState();
  // const [favs, setFavs] = useState(lsFavs);
  // const [list, setList] = useState([]);
  const [state, dispatch] = useReducer(reducer, initialState);
  const url = "https://rickandmortyapi.com/api/character";

  useEffect(() => {
    axios(url).then((res) => {
      console.log(res.data);
      // setList(res.data.results);
      dispatch({ type: "GET_CHARS", payload: res.data.results });
    });
  }, []);
  useEffect(() => {
    localStorage.setItem("favs", JSON.stringify(state.favs));
  }, [state.favs]);
  return (
    <CharStates.Provider value={{ state, dispatch }}>
      {children}
    </CharStates.Provider>
  );
};
export default Context;

export const useCharStates = () => {
  return useContext(CharStates);
};
