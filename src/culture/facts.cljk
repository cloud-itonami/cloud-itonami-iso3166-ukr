(ns culture.facts
  "Country-level regional-culture catalog for Ukraine (UKR) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"UKR"
   [{:culture/id "ukr.dish.borscht"
     :culture/name "Borscht"
     :culture/country "UKR"
     :culture/kind :dish
     :culture/summary "Sour soup made with meat stock, vegetables and seasonings, originating in Ukraine where beet-based red borscht likely developed given soils and climate suited to beet cultivation; UNESCO inscribed the culture of Ukrainian borscht cooking as Intangible Cultural Heritage in Need of Urgent Safeguarding in 2022, while noting several countries in the region have also practiced borscht cooking."
     :culture/url "https://en.wikipedia.org/wiki/Borscht"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ukr.dish.varenyky"
     :culture/name "Varenyky"
     :culture/country "UKR"
     :culture/kind :dish
     :culture/summary "Traditional Ukrainian dumplings made from unleavened dough filled with sweet or savoury ingredients, emblematic of Ukrainian cuisine; the article notes similarity to Polish pierogi, with the Ukrainian version having thinner, softer dough and traditionally simpler filling."
     :culture/url "https://en.wikipedia.org/wiki/Varenyky"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ukr.dish.holubtsi"
     :culture/name "Holubtsi"
     :culture/country "UKR"
     :culture/kind :dish
     :culture/summary "Cabbage rolls with deep roots in Ukrainian cuisine, featuring regional variations from Carpathian corn grits to Poltava buckwheat and holding special importance as a traditional Ukrainian Christmas Eve dish; the dish (cabbage roll) has broader cultural significance across Eastern Europe."
     :culture/url "https://en.wikipedia.org/wiki/Cabbage_roll"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ukr.beverage.horilka"
     :culture/name "Horilka"
     :culture/country "UKR"
     :culture/kind :beverage
     :culture/summary "Ukrainian alcoholic beverage traditionally distilled from grain such as wheat or rye (also made from potatoes, honey, or sugar beets), deeply woven into Ukrainian culture including traditional weddings, with pertsivka (pepper-infused horilka) the most internationally recognized variety."
     :culture/url "https://en.wikipedia.org/wiki/Horilka"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ukr.craft.pysanka"
     :culture/name "Pysanka"
     :culture/country "UKR"
     :culture/kind :craft
     :culture/summary "Wax-resist decorated egg, one of Ukraine's national symbols known throughout the world, a historical folk art practice that has gained renewed significance in contemporary Ukraine."
     :culture/url "https://en.wikipedia.org/wiki/Pysanka"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ukr.craft.vyshyvanka"
     :culture/name "Vyshyvanka"
     :culture/country "UKR"
     :culture/kind :craft
     :culture/summary "Embroidered shirt worn in Ukrainian (and Belarusian) national costume, distinguished by intricate regional embroidery patterns reflecting local traditions and serving as a symbol of Ukrainian cultural identity and patriotism."
     :culture/url "https://en.wikipedia.org/wiki/Vyshyvanka"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ukr.festival.kupala-night"
     :culture/name "Kupala Night"
     :culture/country "UKR"
     :culture/kind :festival
     :culture/summary "Traditional Slavic folk holiday coinciding with the summer solstice, featuring rituals with water, fire, herbs, bonfires, wreaths, and dancing; Ukraine celebrates it with practices such as collecting wormwood for protection and adopted the June 23-24 dates as of 2023. The holiday is shared across multiple Slavic countries with distinct regional variations."
     :culture/url "https://en.wikipedia.org/wiki/Kupala_Night"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "ukr.heritage.saint-sophia-cathedral-kyiv"
     :culture/name "Saint Sophia Cathedral, Kyiv"
     :culture/country "UKR"
     :culture/kind :heritage
     :culture/summary "Architectural monument of Kyivan Rus' located in Kyiv, Ukraine, the inaugural Ukrainian heritage site inscribed on the UNESCO World Heritage List in 1990, alongside the Kyiv Cave Monastery complex."
     :culture/url "https://en.wikipedia.org/wiki/Saint_Sophia_Cathedral,_Kyiv"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-ukr culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "UKR"))
                 " UKR entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
