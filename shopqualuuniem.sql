--
-- PostgreSQL database dump
--

-- Dumped from database version 16.4
-- Dumped by pg_dump version 16.4

-- Started on 2024-10-27 10:38:24

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 230 (class 1259 OID 32864)
-- Name: chi_tiet_hd; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.chi_tiet_hd (
    ma_chi_tiet integer NOT NULL,
    sl_san_pham integer,
    gia_ban real,
    ma_hoa_don integer NOT NULL,
    ma_sp integer NOT NULL
);


ALTER TABLE public.chi_tiet_hd OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 32863)
-- Name: chi_tiet_hd_ma_chi_tiet_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.chi_tiet_hd_ma_chi_tiet_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.chi_tiet_hd_ma_chi_tiet_seq OWNER TO postgres;

--
-- TOC entry 4876 (class 0 OID 0)
-- Dependencies: 229
-- Name: chi_tiet_hd_ma_chi_tiet_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.chi_tiet_hd_ma_chi_tiet_seq OWNED BY public.chi_tiet_hd.ma_chi_tiet;


--
-- TOC entry 232 (class 1259 OID 32883)
-- Name: gio_hang; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gio_hang (
    ma_gio_hang integer NOT NULL,
    gia_sp real,
    ma_tai_khoan integer NOT NULL,
    ma_sp integer NOT NULL
);


ALTER TABLE public.gio_hang OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 32882)
-- Name: gio_hang_ma_gio_hang_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.gio_hang_ma_gio_hang_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.gio_hang_ma_gio_hang_seq OWNER TO postgres;

--
-- TOC entry 4877 (class 0 OID 0)
-- Dependencies: 231
-- Name: gio_hang_ma_gio_hang_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.gio_hang_ma_gio_hang_seq OWNED BY public.gio_hang.ma_gio_hang;


--
-- TOC entry 228 (class 1259 OID 32845)
-- Name: hoa_don; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hoa_don (
    ma_hoa_don integer NOT NULL,
    ngay_ban timestamp(6) with time zone,
    tong_tien real,
    ma_trang_thai integer NOT NULL,
    ma_kh integer NOT NULL
);


ALTER TABLE public.hoa_don OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 32844)
-- Name: hoa_don_ma_hoa_don_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hoa_don_ma_hoa_don_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.hoa_don_ma_hoa_don_seq OWNER TO postgres;

--
-- TOC entry 4878 (class 0 OID 0)
-- Dependencies: 227
-- Name: hoa_don_ma_hoa_don_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.hoa_don_ma_hoa_don_seq OWNED BY public.hoa_don.ma_hoa_don;


--
-- TOC entry 218 (class 1259 OID 32791)
-- Name: khach_hang; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.khach_hang (
    ma_kh integer NOT NULL,
    ten_kh character varying(255),
    dia_chi character varying(255),
    sdt character varying(255)
);


ALTER TABLE public.khach_hang OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 32790)
-- Name: khach_hang_ma_kh_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.khach_hang_ma_kh_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.khach_hang_ma_kh_seq OWNER TO postgres;

--
-- TOC entry 4879 (class 0 OID 0)
-- Dependencies: 217
-- Name: khach_hang_ma_kh_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.khach_hang_ma_kh_seq OWNED BY public.khach_hang.ma_kh;


--
-- TOC entry 222 (class 1259 OID 32817)
-- Name: loai; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.loai (
    ma_loai integer NOT NULL,
    ten_loai character varying(255)
);


ALTER TABLE public.loai OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 32816)
-- Name: loai_ma_loai_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.loai_ma_loai_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.loai_ma_loai_seq OWNER TO postgres;

--
-- TOC entry 4880 (class 0 OID 0)
-- Dependencies: 221
-- Name: loai_ma_loai_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.loai_ma_loai_seq OWNED BY public.loai.ma_loai;


--
-- TOC entry 224 (class 1259 OID 32824)
-- Name: san_pham; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.san_pham (
    ma_sp integer NOT NULL,
    ten_sp character varying(255),
    anh_sp character varying(255),
    so_luong_ton integer,
    gia real,
    mo_ta character varying(255),
    ma_loai integer NOT NULL
);


ALTER TABLE public.san_pham OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 32823)
-- Name: san_pham_ma_sp_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.san_pham_ma_sp_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.san_pham_ma_sp_seq OWNER TO postgres;

--
-- TOC entry 4881 (class 0 OID 0)
-- Dependencies: 223
-- Name: san_pham_ma_sp_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.san_pham_ma_sp_seq OWNED BY public.san_pham.ma_sp;


--
-- TOC entry 220 (class 1259 OID 32800)
-- Name: tai_khoan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tai_khoan (
    ma_tai_khoan integer NOT NULL,
    email character varying(255),
    mat_khau character varying(255),
    ma_vai_tro integer NOT NULL,
    ma_kh integer NOT NULL
);


ALTER TABLE public.tai_khoan OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 32799)
-- Name: tai_khoan_ma_tai_khoan_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tai_khoan_ma_tai_khoan_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.tai_khoan_ma_tai_khoan_seq OWNER TO postgres;

--
-- TOC entry 4882 (class 0 OID 0)
-- Dependencies: 219
-- Name: tai_khoan_ma_tai_khoan_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tai_khoan_ma_tai_khoan_seq OWNED BY public.tai_khoan.ma_tai_khoan;


--
-- TOC entry 226 (class 1259 OID 32838)
-- Name: trang_thai; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.trang_thai (
    ma_trang_thai integer NOT NULL,
    ten_trang_thai character varying(255)
);


ALTER TABLE public.trang_thai OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 32837)
-- Name: trang_thai_ma_trang_thai_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.trang_thai_ma_trang_thai_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.trang_thai_ma_trang_thai_seq OWNER TO postgres;

--
-- TOC entry 4883 (class 0 OID 0)
-- Dependencies: 225
-- Name: trang_thai_ma_trang_thai_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.trang_thai_ma_trang_thai_seq OWNED BY public.trang_thai.ma_trang_thai;


--
-- TOC entry 216 (class 1259 OID 32784)
-- Name: vai_tro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vai_tro (
    ma_vai_tro integer NOT NULL,
    ten_vai_tro character varying(255)
);


ALTER TABLE public.vai_tro OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 32783)
-- Name: vai_tro_ma_vai_tro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.vai_tro_ma_vai_tro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.vai_tro_ma_vai_tro_seq OWNER TO postgres;

--
-- TOC entry 4884 (class 0 OID 0)
-- Dependencies: 215
-- Name: vai_tro_ma_vai_tro_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.vai_tro_ma_vai_tro_seq OWNED BY public.vai_tro.ma_vai_tro;


--
-- TOC entry 4681 (class 2604 OID 32867)
-- Name: chi_tiet_hd ma_chi_tiet; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chi_tiet_hd ALTER COLUMN ma_chi_tiet SET DEFAULT nextval('public.chi_tiet_hd_ma_chi_tiet_seq'::regclass);


--
-- TOC entry 4682 (class 2604 OID 32886)
-- Name: gio_hang ma_gio_hang; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gio_hang ALTER COLUMN ma_gio_hang SET DEFAULT nextval('public.gio_hang_ma_gio_hang_seq'::regclass);


--
-- TOC entry 4680 (class 2604 OID 32848)
-- Name: hoa_don ma_hoa_don; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hoa_don ALTER COLUMN ma_hoa_don SET DEFAULT nextval('public.hoa_don_ma_hoa_don_seq'::regclass);


--
-- TOC entry 4675 (class 2604 OID 32794)
-- Name: khach_hang ma_kh; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.khach_hang ALTER COLUMN ma_kh SET DEFAULT nextval('public.khach_hang_ma_kh_seq'::regclass);


--
-- TOC entry 4677 (class 2604 OID 32820)
-- Name: loai ma_loai; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.loai ALTER COLUMN ma_loai SET DEFAULT nextval('public.loai_ma_loai_seq'::regclass);


--
-- TOC entry 4678 (class 2604 OID 32827)
-- Name: san_pham ma_sp; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.san_pham ALTER COLUMN ma_sp SET DEFAULT nextval('public.san_pham_ma_sp_seq'::regclass);


--
-- TOC entry 4676 (class 2604 OID 32803)
-- Name: tai_khoan ma_tai_khoan; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tai_khoan ALTER COLUMN ma_tai_khoan SET DEFAULT nextval('public.tai_khoan_ma_tai_khoan_seq'::regclass);


--
-- TOC entry 4679 (class 2604 OID 32841)
-- Name: trang_thai ma_trang_thai; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trang_thai ALTER COLUMN ma_trang_thai SET DEFAULT nextval('public.trang_thai_ma_trang_thai_seq'::regclass);


--
-- TOC entry 4674 (class 2604 OID 32787)
-- Name: vai_tro ma_vai_tro; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vai_tro ALTER COLUMN ma_vai_tro SET DEFAULT nextval('public.vai_tro_ma_vai_tro_seq'::regclass);


--
-- TOC entry 4868 (class 0 OID 32864)
-- Dependencies: 230
-- Data for Name: chi_tiet_hd; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.chi_tiet_hd (ma_chi_tiet, sl_san_pham, gia_ban, ma_hoa_don, ma_sp) FROM stdin;
2	3	250000	2	2
\.


--
-- TOC entry 4870 (class 0 OID 32883)
-- Dependencies: 232
-- Data for Name: gio_hang; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.gio_hang (ma_gio_hang, gia_sp, ma_tai_khoan, ma_sp) FROM stdin;
2	210000	2	2
\.


--
-- TOC entry 4866 (class 0 OID 32845)
-- Dependencies: 228
-- Data for Name: hoa_don; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hoa_don (ma_hoa_don, ngay_ban, tong_tien, ma_trang_thai, ma_kh) FROM stdin;
2	2024-10-19 15:01:54.887244+07	160000	2	2
\.


--
-- TOC entry 4856 (class 0 OID 32791)
-- Dependencies: 218
-- Data for Name: khach_hang; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.khach_hang (ma_kh, ten_kh, dia_chi, sdt) FROM stdin;
2	Phan Thi Bich Huyen	DongThap	924687077
\.


--
-- TOC entry 4860 (class 0 OID 32817)
-- Dependencies: 222
-- Data for Name: loai; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.loai (ma_loai, ten_loai) FROM stdin;
2	hoa handmade
4	khung anh
5	hoa len
\.


--
-- TOC entry 4862 (class 0 OID 32824)
-- Dependencies: 224
-- Data for Name: san_pham; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.san_pham (ma_sp, ten_sp, anh_sp, so_luong_ton, gia, mo_ta, ma_loai) FROM stdin;
2	Gau Labubu		13	10000	mot con gau bongllabubu	2
7	Bo hoa LEN		20	150000	mot bo hoa	2
8	Thiep 20/10	\N	2	130000	Thiệp handmade 20/10 	4
9	thiep handmade 20/11	\N	3	150000	Thiep handmade	2
\.


--
-- TOC entry 4858 (class 0 OID 32800)
-- Dependencies: 220
-- Data for Name: tai_khoan; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tai_khoan (ma_tai_khoan, email, mat_khau, ma_vai_tro, ma_kh) FROM stdin;
2	ptbh31@gmail.com	0925677077	2	2
\.


--
-- TOC entry 4864 (class 0 OID 32838)
-- Dependencies: 226
-- Data for Name: trang_thai; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.trang_thai (ma_trang_thai, ten_trang_thai) FROM stdin;
2	khong duyet
\.


--
-- TOC entry 4854 (class 0 OID 32784)
-- Dependencies: 216
-- Data for Name: vai_tro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.vai_tro (ma_vai_tro, ten_vai_tro) FROM stdin;
2	user
\.


--
-- TOC entry 4885 (class 0 OID 0)
-- Dependencies: 229
-- Name: chi_tiet_hd_ma_chi_tiet_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.chi_tiet_hd_ma_chi_tiet_seq', 3, true);


--
-- TOC entry 4886 (class 0 OID 0)
-- Dependencies: 231
-- Name: gio_hang_ma_gio_hang_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.gio_hang_ma_gio_hang_seq', 3, true);


--
-- TOC entry 4887 (class 0 OID 0)
-- Dependencies: 227
-- Name: hoa_don_ma_hoa_don_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hoa_don_ma_hoa_don_seq', 3, true);


--
-- TOC entry 4888 (class 0 OID 0)
-- Dependencies: 217
-- Name: khach_hang_ma_kh_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.khach_hang_ma_kh_seq', 3, true);


--
-- TOC entry 4889 (class 0 OID 0)
-- Dependencies: 221
-- Name: loai_ma_loai_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.loai_ma_loai_seq', 5, true);


--
-- TOC entry 4890 (class 0 OID 0)
-- Dependencies: 223
-- Name: san_pham_ma_sp_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.san_pham_ma_sp_seq', 9, true);


--
-- TOC entry 4891 (class 0 OID 0)
-- Dependencies: 219
-- Name: tai_khoan_ma_tai_khoan_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tai_khoan_ma_tai_khoan_seq', 4, true);


--
-- TOC entry 4892 (class 0 OID 0)
-- Dependencies: 225
-- Name: trang_thai_ma_trang_thai_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.trang_thai_ma_trang_thai_seq', 3, true);


--
-- TOC entry 4893 (class 0 OID 0)
-- Dependencies: 215
-- Name: vai_tro_ma_vai_tro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.vai_tro_ma_vai_tro_seq', 3, true);


--
-- TOC entry 4698 (class 2606 OID 32871)
-- Name: chi_tiet_hd chi_tiet_hd_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chi_tiet_hd
    ADD CONSTRAINT chi_tiet_hd_pkey PRIMARY KEY (ma_chi_tiet);


--
-- TOC entry 4700 (class 2606 OID 32888)
-- Name: gio_hang gio_hang_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gio_hang
    ADD CONSTRAINT gio_hang_pkey PRIMARY KEY (ma_gio_hang);


--
-- TOC entry 4696 (class 2606 OID 32852)
-- Name: hoa_don hoa_don_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hoa_don
    ADD CONSTRAINT hoa_don_pkey PRIMARY KEY (ma_hoa_don);


--
-- TOC entry 4686 (class 2606 OID 32798)
-- Name: khach_hang khach_hang_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.khach_hang
    ADD CONSTRAINT khach_hang_pkey PRIMARY KEY (ma_kh);


--
-- TOC entry 4690 (class 2606 OID 32822)
-- Name: loai loai_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.loai
    ADD CONSTRAINT loai_pkey PRIMARY KEY (ma_loai);


--
-- TOC entry 4692 (class 2606 OID 32831)
-- Name: san_pham san_pham_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.san_pham
    ADD CONSTRAINT san_pham_pkey PRIMARY KEY (ma_sp);


--
-- TOC entry 4688 (class 2606 OID 32805)
-- Name: tai_khoan tai_khoan_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tai_khoan
    ADD CONSTRAINT tai_khoan_pkey PRIMARY KEY (ma_tai_khoan);


--
-- TOC entry 4694 (class 2606 OID 32843)
-- Name: trang_thai trang_thai_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.trang_thai
    ADD CONSTRAINT trang_thai_pkey PRIMARY KEY (ma_trang_thai);


--
-- TOC entry 4684 (class 2606 OID 32789)
-- Name: vai_tro vai_tro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vai_tro
    ADD CONSTRAINT vai_tro_pkey PRIMARY KEY (ma_vai_tro);


--
-- TOC entry 4706 (class 2606 OID 32872)
-- Name: chi_tiet_hd chi_tiet_hd_ma_hoa_don_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chi_tiet_hd
    ADD CONSTRAINT chi_tiet_hd_ma_hoa_don_fkey FOREIGN KEY (ma_hoa_don) REFERENCES public.hoa_don(ma_hoa_don);


--
-- TOC entry 4707 (class 2606 OID 32877)
-- Name: chi_tiet_hd chi_tiet_hd_ma_sp_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.chi_tiet_hd
    ADD CONSTRAINT chi_tiet_hd_ma_sp_fkey FOREIGN KEY (ma_sp) REFERENCES public.san_pham(ma_sp);


--
-- TOC entry 4708 (class 2606 OID 32894)
-- Name: gio_hang gio_hang_ma_sp_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gio_hang
    ADD CONSTRAINT gio_hang_ma_sp_fkey FOREIGN KEY (ma_sp) REFERENCES public.san_pham(ma_sp);


--
-- TOC entry 4709 (class 2606 OID 32889)
-- Name: gio_hang gio_hang_ma_tai_khoan_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gio_hang
    ADD CONSTRAINT gio_hang_ma_tai_khoan_fkey FOREIGN KEY (ma_tai_khoan) REFERENCES public.tai_khoan(ma_tai_khoan);


--
-- TOC entry 4704 (class 2606 OID 32858)
-- Name: hoa_don hoa_don_ma_kh_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hoa_don
    ADD CONSTRAINT hoa_don_ma_kh_fkey FOREIGN KEY (ma_kh) REFERENCES public.khach_hang(ma_kh);


--
-- TOC entry 4705 (class 2606 OID 32853)
-- Name: hoa_don hoa_don_ma_trang_thai_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hoa_don
    ADD CONSTRAINT hoa_don_ma_trang_thai_fkey FOREIGN KEY (ma_trang_thai) REFERENCES public.trang_thai(ma_trang_thai);


--
-- TOC entry 4703 (class 2606 OID 32832)
-- Name: san_pham san_pham_ma_loai_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.san_pham
    ADD CONSTRAINT san_pham_ma_loai_fkey FOREIGN KEY (ma_loai) REFERENCES public.loai(ma_loai);


--
-- TOC entry 4701 (class 2606 OID 32811)
-- Name: tai_khoan tai_khoan_ma_kh_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tai_khoan
    ADD CONSTRAINT tai_khoan_ma_kh_fkey FOREIGN KEY (ma_kh) REFERENCES public.khach_hang(ma_kh);


--
-- TOC entry 4702 (class 2606 OID 32806)
-- Name: tai_khoan tai_khoan_ma_vai_tro_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tai_khoan
    ADD CONSTRAINT tai_khoan_ma_vai_tro_fkey FOREIGN KEY (ma_vai_tro) REFERENCES public.vai_tro(ma_vai_tro);


-- Completed on 2024-10-27 10:38:24

--
-- PostgreSQL database dump complete
--

