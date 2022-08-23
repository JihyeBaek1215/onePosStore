import { useState, useEffect, useRef } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

const List = () => {
  const [data, setData] = useState([]);
  const { current: a } = useRef(['a']);
  console.log(a);

  function getId(str) {
    const idx = str.lastIndexOf('/');
    return str.substring(idx + 1);
  }

  useEffect(() => {
    axios.get('http://localhost:8085' + '/menu/' +'23').then((res) => {
      console.log(res);
      setData(res.data.data);
    });
  }, [a]);

  const listItems = data.map((data, index) => (
    <>
      <li key={index}>
        {/* <div>{data._links.self.href}</div>
        <Link to={'/update/' + getId(data._links.self.href)}> */}
          {`${index}: ${data.menuNm}, ${data.amt}`}
        {/* </Link> */}
      </li>
    </>
  ));

  return (
    <>
      <h1>List!!!</h1>
      <ul>{listItems}</ul>
    </>
  );
};

export default List;
