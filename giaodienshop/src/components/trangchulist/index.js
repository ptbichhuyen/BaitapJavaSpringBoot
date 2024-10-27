import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import "./trangchu.css";
import gau from '../../assets/images/gau1.jpeg';

const TrangchuList=() => {
    const [products, setProducts] = useState([]);
    const [searchQuery, setSearchQuery] = useState('');
    // const [loading, setLoading] = useState(true);
    // const [error, setError] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('http://localhost:8080/Sanpham/getAllSanpham')
        .then(response => {
            const sanphamData = response.data;
            setProducts(sanphamData);
            console.log(sanphamData);
        })
        .catch(error => console.error('Error fetching product:', error));
    }, []);
    const filteredProducts = products.filter(product =>
        product.ten_sp.toLowerCase().includes(searchQuery.toLowerCase()) ||
        product.so_luong_ton.toString().includes(searchQuery.toString()) ||
        product.gia.toString().includes(searchQuery.toString()) ||
        product.mo_ta.toString().includes(searchQuery.toString()) ||
        product.ma_loai.toString().includes(searchQuery.toString())
    );
    return (
        <div>
            <div id="wrapper">
            <div id="header">
                <a href="#" class="logo">
                </a>
                <div id="menu">
                    <div class="item">
                        <a href="/Trangchu">TRANG CHỦ</a>
                    </div>
                    <div class="item">
                        <a href="/Cart">SẢN PHẨM</a>
                    </div>
                    <div class="item">
                        <a href="/Sale">SALE</a>
                    </div>
                    <div class="item">
                        <a href="https://www.facebook.com/profile.php?id=100095235735695">LIÊN HỆ</a>
                    </div>
                </div>
                <div class="search">
                    <input type="text" placeholder=""/>
                </div>
                <div id="actions">
                    <div class="item">
                        <div class="submenu">
                            <form action="xulylogin.html" method="post">
                                <input type="submit" name="logout" value="Đăng xuất"/>
                            </form>
                        </div>
                    </div>
                    <div class="item">
                        <a href="cart.html"></a>
                    </div>
                </div>
            </div>
            <div id="banner">
                <div class="box-left">
                    <h2>
                        <span>YANN & MEOW</span>
                        <br/>
                        <span>SHOP QUÀ LƯU NIỆM</span>
                    </h2>
                    <p>Yann & Meow shop chuyên bán các sản phẩm handmade như: gấu bông, thiệp, scrapbook, hoa,...và các sản phẩm handmade khác. Giá thành hợp lý phù hợp với điều kiện kinh tế, nhanh tay lựa chọn.</p>
                    <button>MUA NGAY</button>
                </div>
                <div class="box-right">
                </div>
                <div class="to-bottom">
                </div>
            </div>
            <div id="wp-products">
                <h2>SẢN PHẨM CỦA SHOP</h2>
                <ul id="list-products">
                    {filteredProducts.map(sp=>(
                    <div class="item" key={sp.ma_sp}>
                        <img src={gau} alt=''/>
                        <div class="stars">
                            <span>
                                <img src="hinh/icons8-star-30.png" alt="" />
                            </span>
                            <span>
                                <img src="hinh/icons8-star-30.png" alt="" />
                            </span>
                            <span>
                                <img src="hinh/icons8-star-30.png" alt="" />
                            </span>
                            <span>
                                <img src="hinh/icons8-star-30.png" alt=""/>
                            </span>
                            <span>
                                <img src="hinh/icons8-star-30.png" alt="" />
                            </span>
                        </div>
                        <div class="name">{sp.ten_sp}</div>
                        <div class="price">{sp.gia} VNĐ</div>
                        <div class="them"></div>
                    </div>
                    ))}
                </ul>

                <div class="saleoff">
                    <div class="box-left">
                        <h1>
                            <span>SỐC!!</span>
                            <span>KHÔNG GIẢM</span>
                        </h1>
                    </div> 
                    <div class="box-right">
                    </div>
                </div>

                <div id="comment">
                    <h2>ĐÁNH GIÁ CỦA KHÁCH HÀNG</h2>
                    <div id="comment-body">
                        <div class="prev">
                            <a href="#">
                                <img src="hinh/icons8-arrow-50.png" alt=""/>
                            </a>
                        </div>
                        <ul id="list-comment"> 
                            <li class="item">
                                <div class="avatar">
                                    <img src="hinh/OIP.jpg"  alt=""/>
                                </div>
                                <div class="stars">
                                    <span>
                                        <img src="hinh/icons8-star-30.png" alt=""/>
                                    </span>
                                    <span>
                                        <img src="hinh/icons8-star-30.png" alt=""/>
                                    </span>
                                    <span>
                                        <img src="hinh/icons8-star-30.png" alt=""/>
                                    </span>
                                    <span>
                                        <img src="hinh/icons8-star-30.png" alt=""/>
                                    </span>
                                    <span>
                                        <img src="hinh/icons8-star-30.png" alt=""/>
                                    </span>
                                </div>
                                <div class="name">Trần Như Ngọc</div>
                                <div class="text">
                                    <p>The product is absolutely amazing, I have bought 10 products from this shop so far for my relatives to use and they are extremely durable. It's not a coincidence that I praise this shop. There is nothing that is both high quality and extremely cheap.</p>
                                </div>
                            </li>
                        </ul>
                        <div class="next">
                            <a href="#">
                                <img src="hinh/icons8-arrow-50 (2).png" alt=""/>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div id="footer">
                <div class="box">
                    <div class="logo">
                        <img src="hinh/logo (1).png" alt="" />
                    </div>
                    <p>Cung cấp những sản phẩm lưu niệm ý nghĩa cho quý khách</p>
                </div>
                <div class="box">
                    <h3>NỘI DUNG</h3>
                    <ul class="quickmenu">
                        <div class="item">
                            <a href="#">Trang chủ</a>
                        </div>
                        <div class="item">
                            <a href="sp.html">Sản phẩm</a>
                        </div>
                        <div class="item">
                            <a href="sale.html">Sale</a>
                        </div>
                        <div class="item">
                            <a href="#">Liên hệ</a>
                        </div>
                    </ul>
                </div>
                <div class="box">
                    <h3>LIÊN HỆ</h3>
                    <a href="https://www.facebook.com/profile.php?id=100010391102377&locale=vi_VN">
                        <img src="hinh/2023_Facebook_icon.svg.png" />
                    </a>
                    <a href="https://www.instagram.com/lesleyqing2908/">
                        <img src="hinh/instagram.png"  alt=""/>
                    </a>
                </div>
            </div>
        </div>
            <ToastContainer/>
        </div>
    );
};

export default TrangchuList;