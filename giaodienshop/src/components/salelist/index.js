import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import "../trangchulist/trangchu.css";
import gau from '../../assets/images/gau1.jpeg';
import gaubong from '../../assets/images/gau2.jpeg';
import hoa from '../../assets/images/hoadatset3.jpeg';
import khung from '../../assets/images/khungtreoanh2.png';
import hoalen from '../../assets/images/hoalen1.webp';
import scrap from '../../assets/images/scrapbook1.jpeg';
import crap from '../../assets/images/scrapbook2.jpeg';
import cb from '../../assets/images/combo1.jpeg';
const SaleList=() => {
    const [products, setProducts] = useState([]);
    const [searchQuery, setSearchQuery] = useState('');
    // const [loading, setLoading] = useState(true);
    // const [error, setError] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        axios.get('http://localhost:8080/Sanpham/getAll')
        .then(response => {
            const sanphamData = response.data;
            setProducts(sanphamData);
            console.log(sanphamData);
        })
        .catch(error => console.error('Error fetching product:', error));
    }, []);

    return (
        <div>
            <div id="wrapper">
            <div id="header">
                <a href="" class="logo">
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
                            <button onclick="logout()">Đăng xuất</button>
                        </div>
                    </div>
                    <div class="item">
                        <a href="cart.html"></a>
                    </div>
                </div>
            </div>
            <div class="container">
                <header>
                    <h1>Tất cả sản phẩm </h1>
                </header>
                <div id="wp-products">
                    
                    <ul id="list-products">
                        <div class="item">
                        <img src={gau} alt=''/>
                            <div class="name">GẤU BÔNG TEDDY ÁO LEN</div>
                            <div class="price">109.000 VNĐ</div>
                            <div class="sale"><p><del>129.000 VNĐ</del></p></div>
                            <div class="mua">
                                <a href="cart.html"><button>Mua ngay</button></a>
                            </div>
                            <div class="them"></div>
                        </div>

                        <li class="item">
                        <img src={gaubong} alt=''/>
                            <div class="stars"></div>
                            <div class="name">GẤU BÔNG MÈO HOÀNG THƯỢNG</div>
                            <div class="price">95.000 VNĐ</div>
                            <div class="sale"><p><del>135.000 VNĐ</del></p></div>
                            <div class="mua">
                                <a href="cart.html"><button>Mua ngay</button></a>
                            </div>
                            <div class="them"></div>
                        </li>

                        <li class="item">
                        <img src={khung} alt=''/>
                            <div class="stars">
                            </div>
                            <div class="name">KHUNG ẢNH KIỂU DÁNG TAI MÈO</div>
                            <div class="price">179.000 VNĐ</div>
                            <div class="sale"><p><del>203.000 VNĐ</del></p></div>
                            <div class="mua">
                                <a href="cart.html"><button>Mua ngay</button></a>
                            </div>
                            <div class="them"></div>
                        </li>

                        <li class="item">
                        <img src={cb} alt=''/>
                            <div class="stars">
                            </div>
                            <div class="name">COMBO QUÀ</div>
                            <div class="price">140.000 VNĐ</div>
                            <div class="sale"><p><del>199.000 VNĐ</del></p></div>
                            <div class="mua">
                                <a href="cart.html"><button>Mua ngay</button></a>
                            </div>
                            <div class="them"></div>
                        </li>

                        <li class="item">
                        <img src={hoa} alt=''/>
                            <div class="stars">
                            </div>
                            <div class="name">BÓ HOA ĐẤT SÉT ĐỦ MÀU</div>
                            <div class="price">279.000 VNĐ</div>
                            <div class="sale"><p><del>379.000 VNĐ</del></p></div>
                            <div class="mua">
                                <a href="cart.html"><button>Mua ngay</button></a>
                            </div>
                            <div class="them"></div>
                        </li>

                        <li class="item">
                        <img src={hoalen} alt=''/>
                            <div class="stars">
                            </div>
                            <div class="name">BÓ HOA LEN HANDMADE</div>
                            <div class="price">220.000 VNĐ</div>
                            <div class="sale"><p><del>280.000 VNĐ</del></p></div>
                            <div class="mua">
                                <a href="cart.html"><button>Mua ngay</button></a>
                            </div>
                            <div class="them"></div>
                        </li>

                        <li class="item">
                        <img src={scrap} alt=''/>
                            <div class="stars">
                            </div>

                            <div class="name">SCRAPBOOK</div>
                            <div class="price">138.000 VNĐ</div>
                            <div class="sale"><p><del>170.000 VNĐ</del></p></div>
                            <div class="mua">
                                <a href="cart.html"><button>Mua ngay</button></a>
                            </div>
                            <div class="them"></div>
                        </li>

                        <li class="item">
                        <img src={crap} alt=''/>
                            <div class="stars">
                            </div>
                            <div class="name">SCRAPBOOK</div>
                            <div class="price">190.000 VNĐ</div>
                            <div class="sale"><p><del>230.000 VNĐ</del></p></div>
                            <div class="mua">
                                <a href="cart.html"><button>Mua ngay</button></a>
                            </div>
                            <div class="them"></div>
                        </li>
                    </ul>
                </div>
            </div>
            <ToastContainer/>
            </div>
        </div>
    );
};

export default SaleList;