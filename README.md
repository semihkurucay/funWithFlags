# 🚩 Fun With Flags - Bayrak Tahmin Oyunu

Dr. Sheldon Lee Cooper ve Dr. Amy Farrah Fowler'ın sunduğu Oscar ödüllü (veya en azından bizim kalbimizin birincisi) *Fun With Flags* programından ilham alınarak geliştirilmiş, Java tabanlı eğlenceli bir bayrak tahmin oyunudur.

Bazinga!

## 🎮 Oyunun Amacı
Sistemde yüklü olan bayrakların kime ait olduğunu 4 şık arasından doğru tahmin etmek. Klasik ezber oyunlarının aksine, oyun tamamen dinamik bir yapıya sahiptir. Seçenekler ve bayrak sıraları her oynayışta rastgele ve benzersiz olarak oluşturulur.

## ✨ Özellikler

* **Dinamik Bayrak Sistemi:** Oyuna yeni bayraklar eklemek için koda dokunmanıza gerek yoktur. Sistem `Flags` sınıfından gelen veriyi okur ve algoritma kendini mevcut bayrak sayısına göre otomatik ayarlar.
* **Akıllı Puanlama:** Puan sistemi, sistemdeki toplam bayrak sayısına göre otomatik olarak hesaplanır (Örn: 10 bayrak varsa soru başı 10 puan, 20 bayrak varsa soru başı 5 puan).
* **Defansif Programlama (Güvenli Çalışma):** Oyunun oynanabilmesi için sistemde en az 4 bayrak bulunması gerekir. Aksi takdirde oyun hata verip çökmek yerine kullanıcıyı bilgilendirir ve güvenli bir şekilde kapanır.
* **Kusursuz Seçenek Algoritması:** Şıklar oluşturulurken `Collections.shuffle()` yapısı kullanılmıştır. Yanlış şıkların veya doğru cevabın birbirini tekrar etme (çakışma) ihtimali sıfırdır.
* **Anlık Geri Bildirimler:** Doğru ve yanlış cevaplarda kullanıcıya anında görsel diyalog kutuları (JOptionPane) ile bilgi verilir. Yanlış cevaplarda doğrusu gösterilir.

## 📸 Ekran Görüntüleri

| Giriş Ekranı | Soru Ekranı |
|:---:|:---:|
| <img src="images/intro.png" width="300"> | <img src="images/gameplay.png" width="300"> |
| **Doğru/Yanlış Bildirimi** | **Oyun Sonu** |
| <img src="images/feedback.png" width="300"> | <img src="images/gameover.png" width="300"> |
