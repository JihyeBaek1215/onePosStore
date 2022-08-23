import axios from 'axios';

const Create = () => {
  function handleChange(e) {
    const params = {
      menuNm: document.getElementById('menuNm').value,
      amt: document.getElementById('amt').value,
      qty: document.getElementById('qty').value,
      storeId: '23',
    };
    axios
      .post('http://localhost:8085' + '/menus', params)
      .then((res) => {
        console.log(res.data);
      });
  }
  return (
    <>
      <h1>Create!!</h1>
      <input type="text" placeholder="메뉴명" id="menuNm" />
      <input type="number" placeholder="가격" id="amt" />
      <input type="number" placeholder="재고수량" id="qty" />
      <input type="hidden" placeholder="매장ID" id="storeId" />
      <button type="submit" onClick={handleChange}>
        Submit
      </button>
    </>
  );
};

export default Create;
