(ns marketentry.facts-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.facts :as facts]))

(deftest ukr-has-spec-basis
  (let [sb (facts/spec-basis "UKR")]
    (is (some? sb))
    (is (string? (:provenance sb)))
    (is (seq (:required-evidence sb)))
    (is (some? (facts/rep-spec-basis "UKR")))
    (is (some? (facts/corporate-number-spec-basis "UKR")))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest required-evidence-satisfied
  (let [sb (facts/spec-basis "UKR")
        all (:required-evidence sb)]
    (is (true? (facts/required-evidence-satisfied? "UKR" all)))
    (is (not (facts/required-evidence-satisfied? "UKR" (take 1 all))))
    (is (nil? (facts/required-evidence-satisfied? "ATL" all)))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["UKR" "ATL" "ZZZ"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["UKR"] (:covered-jurisdictions c)))
    (is (= ["ATL" "ZZZ"] (:missing-jurisdictions c)))))

(deftest catalog-is-ukraine-only
  (testing "no unlabeled foreign-jurisdiction contamination (scaffold-copy incident)"
    (is (= #{"UKR"} (set (keys facts/catalog))))))
