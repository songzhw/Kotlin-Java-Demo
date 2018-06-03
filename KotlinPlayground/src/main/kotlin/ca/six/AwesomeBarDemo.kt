package ca.six

import java.net.URL
import java.util.*


class AwesomeBarSearchResult(val url: String, val score: Int, val timeStamp: Long) {
}

interface AwesomeBar {
    fun load(url: String, timestamp: Date, isOpenTab: Boolean)
    fun search(query: String): List<AwesomeBarSearchResult>
}

class UrlItem(val url: String, val host: String, val path: String, val timeStamp: Long, val isOpenTab: Boolean) {
}

// Mock a database
//val database: HashMap<String, UrlItem> = HashMap()
val database: ArrayList<UrlItem> = ArrayList()

class SimpleAwesomeBar : AwesomeBar {
    override fun load(url: String, timestamp: Date, isOpenTab: Boolean) {
        val urlObject = URL(url)
        database.add(UrlItem(url, urlObject.host, urlObject.path, timestamp.time, isOpenTab))
    }

    override fun search(query: String): List<AwesomeBarSearchResult> {
        val searchResults: ArrayList<AwesomeBarSearchResult> = ArrayList()

        val keywords = query.split(" ")
        database.forEach nextUrlItem@ { urlItem ->
            var score = 0
            keywords.forEach { keyword ->
                var scoreInThisKeyword = 0
                val url = urlItem.url

                // calculate the score
                if (keyword.equals(urlItem.host)) {
                    scoreInThisKeyword += 50
                } else if (urlItem.host.contains(keyword)) {
                    scoreInThisKeyword += 25
                }

                if (urlItem.path.contains(keyword)) {
                    scoreInThisKeyword += 10
                }

                // if no match, move on to next urlItem;
                if (scoreInThisKeyword == 0) {
                    return@nextUrlItem
                } else {
                    score += scoreInThisKeyword
                }
            }


            if (urlItem.isOpenTab) {
                score += 250
            }


            // every query item is matched, then add it to the searchResult
            val result = AwesomeBarSearchResult(urlItem.url, score, urlItem.timeStamp)
            searchResults.add(result)
        }

        // only get five
        // order alphabetically
        val optimizedResults = searchResults
                .sortedWith(kotlin.Comparator<AwesomeBarSearchResult> { result1, result2 ->
                    if(result2.score == result1.score){
                        result2.timeStamp.compareTo(result1.timeStamp)
                    } else {
                        result2.score.compareTo(result1.score)
                    }
                })
                .take(5)

        return optimizedResults
    }

}

// hostname: exactly match, 50+
// hostname: contains, 25+
// path: contains, 10+
// isOpenTab: 250+

// IMPLEMENT YOUR CODE HERE
fun main(args: Array<String>) {
    val awesomeBar = SimpleAwesomeBar()
    val history = arrayOf(

            "https://www.youtube.com/watch?v=dC9vdQkU-xI",
            "https://hbr.org/2018/04/how-to-develop-empathy-for-someone-who-annoys-you",
            "https://arxiv.org/abs/1804.07612",
            "https://rollbar.com/blog/top-10-ruby-on-rails-errors/",
            "http://tomkadwill.com/running-rails-on-aws-elastic-beanstalk",
            "https://arstechnica.com/science/2018/04/a-short-new-movie-of-a-comets-surface-is-pretty-incredible/",
            "https://bugs.ruby-lang.org/issues/14709",
            "https://github.com/ckeditor/ckeditor5/issues/991",
            "https://unreasonable.is/color-gradients-can-help-read-better-faster/",
            "https://www.imore.com/rip-airport",
            "https://medium.com/algebraix-data/coins-v-stocks-which-should-you-buy-bigmaccoin-or-mcdonalds-stock-3e54388218ea",
            "https://www.scientificamerican.com/article/human-brain-gain-computer-models-hint-at-why-we-bested-neandertals/",
            "https://www.bloomberg.com/news/articles/2018-04-26/eu-asks-is-the-net-essential-the-answer-could-hurt-google",
            "https://nypost.com/2018/04/25/ex-new-yorkers-are-flocking-to-this-midwest-sanctuary/",
            "https://github.com/stevemk14ebr/GeLuBigNum",
            "https://increment.com/programming-languages/goldilocks-language-history-of-julia/",
            "http://www.huckmagazine.com/art-and-culture/film-2/skater-turned-filmmaker-sea-shining-sea-interview-maximon-monihan/",
            "https://www.technologyreview.com/s/610922/win-more-social-media-followers-with-this-trick/",
            "https://www.youtube.com/watch?v=fwfXhSXHOs4",
            "https://techcrunch.com/2018/04/26/the-alternative-to-the-four-hour-work-week-mindset/",
            "https://www.technologyreview.com/s/611007/researchers-are-keeping-pig-brains-alive-outside-the-body/",
            "http://flask.pocoo.org/docs/1.0/changelog/#version-1-0",
            "https://blog.wallaroolabs.com/2018/04/adventures-with-cgo-part-2--locks-and-other-things-that-go-bump-in-the-night/",
            "https://medium.com/@leo_pold_b/coinbases-crypto-empire-120b855b2e93",
            "https://patreonhq.com/diversity-and-inclusion-at-patreon-9d835c774db5",
            "https://waydev.co/",
            "https://sitety.com/how-to-generate-a-free-wildcard-ssl-certificate-with-lets-encrypt-for-your-domain/",
            "https://www.cringely.com/2018/04/20/15514/",
            "http://techsparket.com/data-mining-top-20-web-crawler-tools-scrape-websites-actionable-data/",
            "https://mammoth.bio/",
            "https://medicalxpress.com/news/2018-04-bit-dark-chocolate-sweeten-vision.html",
            "http://nautil.us/issue/59/connections/another-side-of-feynman",
            "https://airdev.co/very-lean-guide-to-lean-app-development",
            "http://www.ethoberon.ethz.ch/WirthPubl/CBEAll.pdf",
            "https://blog.the-pans.com/time-and-order/",
            "http://neupy.com/2018/03/26/making_art_with_growing_neural_gas.html",
            "https://techcrunch.com/2018/04/26/mammoth-crispr-jennifer-doudna-crispr/",
            "https://www.hpe.com/us/en/insights/articles/a-new-life-for-old-am-broadcast-towers-1804.html",
            "https://www.zdnet.com/article/ubuntu-18-04-lts-the-linux-for-ai-clouds-and-containers/",
            "https://techcrunch.com/2018/04/26/what-we-learned-from-facebooks-latest-data-misuse-grilling/",
            "https://techcrunch.com/2018/04/26/moviepass-ceo-one-movie-per-day/",
            "http://www.unicode.org/L2/L2017/17435r-terminals-prop.pdf",
            "https://arstechnica.com/cars/2018/04/months-of-bad-news-has-battered-teslas-image-with-customers-poll-finds/",
            "https://www.bignerdranch.com/blog/dont-over-react/",
            "https://read.acloud.guru/building-a-serverless-multi-region-active-active-backend-36f28bed4ecf",
            "https://www.bignerdranch.com/blog/big-nerd-ranch-are-top-ux-designers/",
            "https://www.palletsprojects.com/blog/flask-1-0-released/",
            "https://medium.com/algebraix-data/shocking-news-facebook-not-the-worst-data-pirate-4d37d5f8f63d",
            "https://www.producthunt.com/posts/hiringplan",
            "https://www.theverge.com/2018/4/26/17286954/square-weebly-buying-acquistion-365-million-website-store-retail",
            "https://www.firststepcoding.com/blockchain-course.html",
            "https://github.com/bisratyalew/flask-rest-api",
            "http://gwan.com/blog/20160405.html",
            "https://news.alphastreet.com/amazon-earnings-jump-on-strong-sales-growth-beat-street-view/",
            "https://www.microsoft.com/en-us/Investor/earnings/FY-2018-Q3/press-release-webcast",
            "https://www.cnbc.com/2018/04/26/amazon-earnings-q1-2018.html",
            "https://github.com/giovanifss/Gitmails",
            "https://www.quantamagazine.org/cell-by-cell-scientists-map-the-genetic-steps-as-eggs-become-animals-20180426/",
            "https://medium.com/trustroot/disrupting-blockchain-security-can-a-decentralized-certificate-authority-improve-trust-in-1d7af5d7fb2",
            "http://www.mlive.com/news/ann-arbor/index.ssf/2018/04/man_gets_7_years_in_federal_pr.html",
            "http://neurosciencenews.com/brain-synchrony-working-memory-8887/",
            "http://phx.corporate-ir.net/phoenix.zhtml?c=97664&p=irol-newsArticle&ID=2345075",
            "https://aaron-hoffman.blogspot.com/2018/04/programmatically-add-other-search-engines-to-google-chrome-for-vsts-shortcuts.html",
            "https://www.cnbc.com/2018/04/26/square-to-buy-weebly-for-365-million.html",
            "https://squareup.com/news/square-to-acquire-weebly",
            "https://medium.com/myplanet-musings/innovation-spikes-conference-day-and-company-growth-a4fc5012f437",
            "https://medium.com/@adrienjoly/comment-g%C3%A9n%C3%A9rer-un-revenu-en-d%C3%A9veloppant-seul-son-produit-6a05f32524bd",
            "https://medium.com/@jayhanlon/welcome-wagon-dd57cbdd54d9",
            "https://roadwarrior.blog/time-blocking/",
            "https://lwn.net/Articles/752063/",
            "https://mjg59.dreamwidth.org/11235.html",
            "https://github.com/255kb/mockoon",
            "https://www.recode.net/2018/2/1/16961598/amazon-jeff-bezos-record-profit-11-quarter-q4-2017-earnings",
            "https://kotaku.com/some-numbers-that-illustrate-nintendo-switchs-massive-s-1825561698",
            "https://www.wired.com/story/pinterest-skin-tone-search",
            "https://www.reuters.com/article/us-eu-tech/eu-moves-to-regulate-tech-giants-business-practices-idUSKBN1HX13T",
            "http://phx.corporate-ir.net/phoenix.zhtml?c=97664&p=RssLanding&cat=news&id=2345075",
            "https://www.smithsonianmag.com/science-nature/mapping-history-first-nations-people-through-their-genes-180968899/?no-ist",
            "http://www.logicmazes.com/games/eleusis/express.html",
            "https://www.top500.org/news/doe-unveils-exascale-earth-modeling-system/",
            "https://www.japantimes.co.jp/news/2018/04/26/world/facebook-lobbying-failed-google-takes-aim-u-s-law-banning-use-biometric-data-without-consent/",
            "https://slack.engineering/moving-fast-and-securing-things-540e6c5ae58a",
            "https://www.businessinsider.com/amazon-ceo-jeff-bezos-liquidates-billions-to-fund-blue-origin-2018-4?r=US&IR=T",
            "https://blog.golang.org/go-brand",
            "https://sdtimes.com/os/ubuntu-18-04-focuses-on-security-and-ai-improvements/",
            "https://medium.com/syncedreview/chip-guru-jim-keller-leaves-tesla-for-intel-34affc4a6490",
            "https://www.newstatesman.com/politics/uk/2018/04/humanist-left-must-challenge-rise-cyborg-socialism",
            "https://www.npmjs.com/package/metaproperties",
            "https://www.linkedin.com/pulse/has-time-arrived-strongman-business-leader-pierre-collowald/",
            "https://stackoverflow.blog/2018/04/26/stack-overflow-isnt-very-welcoming-its-time-for-that-to-change/",
            "https://blog.code-orange.nl/on-setting-up-a-private-package-repository-414f03b51347",
            "https://kottke.org/18/04/the-face-of-distracted-driving",
            "https://metropolitan.fi/entry/researchers-make-breakthrough-in-quantum-entanglement-that-could-enable-teleporting-in-the-future",
            "https://medium.com/@navjotts/analyzing-a-dataset-the-step1-of-machine-learning-which-often-gets-overlooked-415ca65ed2f1",
            "https://www.theatlantic.com/technology/archive/2018/04/what-happens-when-your-bomb-defusing-robot-becomes-a-weapon/558758/?single_page=true",
            "https://aeon.co/essays/theres-no-philosophy-of-life-without-a-theory-of-human-nature",
            "https://ipvm.com/reports/amazon-home-security-2018",
            "https://techcrunch.com/2018/04/26/amazon-is-now-selling-home-security-services-including-installations-and-no-monthly-fees/",
            "https://catch.cryptland.com",
            "https://kev.inburke.com/kevin/quick-dirty-profiling/",
            "http://closertotruth.com/contributor/scott-aaronson/profile",
            "https://www.applevis.com/guides/ios-voiceover/complete-list-ios-gestures-available-voiceover-users",
            "https://www.nytimes.com/2018/04/25/business/ford-earnings.html",
            "https://apnews.com/66ba264a7ec04ccfae0d26f759dcc482/Bill-Cosby-convicted-of-drugging-and-molesting-a-woman",
            "https://bassi.li/blog/2018/04/24/creating-the-perfect-playlist-shuffle-feature-in-python.html",
            "https://www.jdsupra.com/legalnews/sec-penalizes-yahoo-35-million-for-20427/",
            "https://habitlab.stanford.edu/",
            "https://www.bloomberg.com/view/articles/2018-04-26/neo-nazis-have-rights-too",
            "http://www.dailymail.co.uk/sciencetech/article-5659235/Pig-brains-kept-alive-WITHOUT-body-time.html",
            "https://radar.qrator.net/blog/bgp-hijacks-malicious-or-mistakes",
            "https://www.evernote.com/shard/s207/sh/022f2237-4b4f-4096-87f2-053acd228c2d/ede2672bc3f39a1b0232f84e01ca0a83",
            "https://www.theverge.com/2018/4/26/17284408/alexa-skill-alien-offworld-colony-simulator-escape-from-xenomorph-rpg-game",
            "https://pythoninsider.blogspot.com/2018/04/new-pypi-launched-legacy-pypi-shutting.html",
            "https://www.joelonsoftware.com/2000/05/24/strategy-letter-ii-chicken-and-egg-problems/",
            "http://wiki.c2.com/?PrinciplesOfObjectOrientedDesign",
            "http://www.nackerhews.com/",
            "https://medium.com/epsagon/lambda-internals-exploring-aws-lambda-462f05f74076",
            "https://techcrunch.com/2018/04/26/mozilla-hubs-is-a-super-simple-social-chat-room-for-robots/",
            "https://improvingsoftware.com/2009/05/19/programmers-before-you-turn-40-get-a-plan-b/",
            "https://techcrunch.com/2018/04/26/ibm-introduces-trustchain-a-blockchain-to-verify-the-jewelry-supply-chain/",
            "https://stacksense.io/krishnan/machine-learning/ai-in-observability-splunk-goes-further-bringing-ai-to-their-products/",
            "https://www.youtube.com/watch?v=0ZE1_bRUgsA",
            "https://github.com/AllThingsSmitty/css-protips",
            "https://monades.roperzh.com/weekly-command-fuzzy-finding-everything-with-fzf/",
            "https://www.washingtonpost.com/news/innovations/wp/2018/04/26/ford-has-been-synonymous-with-cars-for-more-than-a-century-thats-about-to-change/",
            "https://kev.inburke.com/kevin/quick-dirty-profiling/?hn",
            "https://blog.plover.com/math/roman-numeral-order.html",
            "https://github.com/Coinward/NetworkValue.info",
            "https://www.epicgames.com/fortnite/en-US/news/postmortem-of-service-outage-4-12",
            "http://scmp.com/tech/china-tech/article/2143537/chinese-weapons-lab-putting-missile-technology-airport-body-scanners",
            "https://www.nicolaferraro.me/2018/04/25/saga-pattern-in-apache-camel/",
            "http://tech.adroll.com/blog/data-science/2018/04/26/just-binary-classifier.html",
            "https://blog.acolyer.org/2018/04/26/skyway-connecting-managed-heaps-in-distributed-big-data-systems/",
            "https://www.nytimes.com/2018/04/26/upshot/the-era-of-very-low-inflation-and-interest-rates-may-be-near-an-end.html",
            "http://metro.co.uk/2018/04/26/new-sign-warns-motorists-smartphone-zombies-area-7500588/",
            "https://hackernoon.com/blockchains-should-not-be-democracies-14379e0e23ad",
            "https://banzaicloud.com/blog/announcing-bank-vaults/",
            "https://www.cnri.reston.va.us/kahn-cerf-88.pdf",
            "https://www.npr.org/sections/ed/2018/04/25/605092520/high-paying-trade-jobs-sit-empty-while-high-school-grads-line-up-for-university",
            "https://tspn1.blogspot.com/2018/04/xiaomi-mi-a2-mi-6x-features-spicifications-and-price.html#more",
            "https://www.nytimes.com/2018/04/26/arts/television/bill-cosby-guilty-retrial.html",
            "https://www.cbsnews.com/news/waffle-house-tennessee-shooting-james-shaw-jr-antioch/?ftag=COS-05-10aaa0g&utm_campaign=trueAnthem:+New+Content+(Feed)&utm_content=5ae1564204d30108f9b0e7d5&utm_medium=trueAnthem&utm_source=twitter",
            "https://blog.cardash.com/are-you-right-for-a-startup-dd9f7176650c",
            "https://blog.foreflight.com/2018/04/23/foreflight-10-better-app-search-airspace-profile-automatic-downloads/",
            "https://medium.com/detour-dot-com/detour-the-next-chapter-6f1aa2d97a14",
            "https://9to5google.com/2018/04/26/what-is-material-design-2-examples-launch-io/",
            "https://blog.ycombinator.com/announcing-startup-school-beijing/",
            "https://www.cloudamqp.com/blog/2018-04-26-diagnostic-tool-for-RabbitMQ.html",
            "https://www.engadget.com/2018/04/26/crispr-pioneer-make-at-home-test-that-detects-disease/",
            "https://www.bloomberg.com/news/articles/2018-04-26/how-short-sellers-built-a-business-on-security-bugs",
            "https://splinternews.com/corporate-america-is-conspiring-to-keep-your-chocolate-1825514264",
            "https://wiki.nikitavoloboev.xyz/life/happiness.html",
            "https://medium.com/ontologynetwork/ontology-launches-vbft-a-next-generation-consensus-mechanism-becoming-one-of-the-first-vrf-based-91f782308db4",
            "https://thewalrus.ca/the-newest-brain-wave-in-epilepsy-care/",
            "https://github.com/tensorflow/swift",
            "https://www.theatlantic.com/business/archive/2018/04/what-its-like-to-work-at-the-museum-of-ice-cream/558269/?single_page=true",
            "http://ai.robotvera.com",
            "https://github.com/mischah/Relaxed",
            "http://bair.berkeley.edu/blog/2018/04/26/tdm/",
            "http://steve-yegge.blogspot.com/2006/03/execution-in-kingdom-of-nouns.html",
            "https://qz.com/1259524/mmm-and-bitcoin-russian-ponzi-mastermind-sergei-mavrodi-is-dead-but-his-legacy-lives-on-in-crypto/",
            "https://github.com/tensorflow/swift/blob/master/docs/DesignOverview.md",
            "https://www.economist.com/news/united-states/21741174-hawaii-becomes-sixth-states-allow-doctors-give-lethal-medication-some",
            "http://www.cbc.ca/news/politics/march-madness-fiscal-smartphones-1.4634779",
            "https://medium.com/tensorflow/introducing-swift-for-tensorflow-b75722c58df0",
            "https://gsuiteupdates.googleblog.com/2018/04/think-macro-google-sheets.html",
            "https://www.inc.com/geoffrey-james/collaboration-creates-mediocrity-not-excellence-according-to-science.html",
            "https://newsroom.intel.com/news-releases/jim-keller-joins-intel-lead-silicon-engineering/",
            "https://www.nhregister.com/technology/businessinsider/article/Everything-we-know-about-the-OnePlus-6-one-of-12802845.php",
            "http://markmhendrickson.com/posts/homesteading-on-the-indie-web",
            "https://medium.com/@pichsenmeister/from-hero-to-zero-closing-my-3rd-startup-9397840298d9",
            "https://developer.amazon.com/blogs/alexa/post/60e1f011-3236-4162-b0f6-509205d354ca/making-alexa-more-friction-free",
            "https://www.theverge.com/2018/4/25/17279294/toronto-massacre-minassian-incels-internet-misogyny",
            "https://www.insaturnsrings.com/trailer",
            "https://www.overclockers.at/articles/the-hpet-bug-what-it-is-and-what-it-isnt",
            "https://www.anandtech.com/show/12689/cpu-design-guru-jim-keller-joins-intel",
            "https://splinternews.com/before-basic-income-fix-capitalism-1825528346",
            "https://blog.color.com/building-a-high-quality-reliable-and-efficient-bioinformatics-pipeline-aa4a01e182ba",
            "https://lwn.net/Articles/751763/",
            "http://www.mcclatchydc.com/news/nation-world/national/national-security/article209814729.html",
            "http://obem.be/2018/04/26/sending-bulk-emails-with-mailgun.html",
            "https://www.youtube.com/watch?v=UoFUnAkfRvE",
            "https://hackernoon.com/how-the-nintendo-switch-prevents-downgrades-by-irreparably-blowing-its-own-fuses-884bd3b7a8ba",
            "https://ethos.itu.dk/2018/04/16/keeping-computation-open-for-interpretation/",
            "http://nymag.com/selectall/2018/04/malcolm-harris-on-glitch-capitalism-and-ai-logic.html",
            "https://qz.com/1246712/im-building-a-robot-boyfriend-and-you-can-too/",
            "https://medium.com/s/a-brief-history-of-attention/how-likes-went-bad-b094ddd07d4",
            "https://github.com/krishnakumarsekar/awesome-quantum-machine-learning",
            "https://danielmiessler.com/blog/continuous-asset-management-security/",
            "https://sanctus.io/social-media-mental-health-b1803b6b475f",
            "https://increment.com/programming-languages/",
            "https://en.fabernovel.com/insights/tech-en/hq-trivia-reverse-engineering",
            "https://matrix.org/blog/2018/04/26/matrix-and-riot-confirmed-as-the-basis-for-frances-secure-instant-messenger-app/",
            "https://cleantechnica.com/2018/04/24/china-installs-nearly-10-gigawatts-of-solar-in-first-quarter-up-22/",
            "http://www.paulgraham.com/rootsoflisp.html",
            "https://www.washingtonpost.com/news/true-crime/wp/2018/04/24/recycling-innovator-eric-lundgren-loses-appeal-on-computer-restore-discs-must-serve-15-month-prison-term/?noredirect=on&utm_term=.0f03ddc6b0f8",
            "https://www.hakaimagazine.com/features/power-compassion/",
            "https://github.com/horazont/xmpp-echo-bot",
            "http://lifefaker.com/",
            "https://gizmodo.com/inside-amds-quest-to-build-chips-that-can-beat-intel-1824064984",
            "https://www.extremetech.com/computing/268300-man-gets-15-month-prison-sentence-microsoft-windows-restore",
            "https://www.scientificamerican.com/article/shoebox-sized-lab-can-diagnose-infectious-diseases-from-a-drop-of-blood/",
            "https://www.xconomy.com/san-francisco/2018/04/26/home-tests-in-mind-doudna-startup-races-rivals-in-crispr-diagnostics/",
            "https://www.candyjapan.com/behind-the-scenes/fraudulent-transaction-warning-signs",
            "https://www.npr.org/sections/ed/2018/04/26/604875394/study-colleges-that-ditch-the-sat-and-act-can-enhance-diversity",
            "http://lucumr.pocoo.org/2013/2/13/moar-classes/",
            "https://www.indiehackers.com/interview/how-my-newsletter-for-developers-generates-subscription-revenue-8fff929be1",
            "https://blockchain.works-hub.com/learn/functional-programming-crypto-reading-list-1bd94",
            "http://nwn.blogs.com/nwn/2018/04/gdpr-social-vr-high-fidelity-sansar-sl-sinespace.html",
            "http://www.cs.columbia.edu/~amueller/comsw4995s18/schedule/",
            "https://www.amd.com/en/where-to-buy/combat-crate",
            "https://blog.docker.com/2018/04/networking-in-docker-enterprise-edition-2-0/",
            "http://hackingdistributed.com/2018/04/26/online-signing-broken/",
            "http://alistapart.com/article/the-illusion-of-control-in-web-design",
            "https://lemire.me/blog/2018/04/26/why-a-touch-of-secrecy-can-help-creative-work/",
            "https://www.nytimes.com/2018/04/25/opinion/cars-ruining-cities.html",
            "https://www.cnbc.com/2018/04/26/facebook-cto-admits-firm-didnt-read-terms-of-aleksandr-kogans-app.html",
            "https://bcyphers.github.io/campaign-names/",
            "https://fpgaer.wordpress.com/2018/04/26/as-time-goes-by/",
            "http://www.akwconsultancy.com",
            "https://github.com/HelloElephant/Parade/blob/master/README.md",
            "https://swift.org/blog/iuo/",
            "https://github.com/daviddao/awful-ai",
            "http://www.cbc.ca/news/technology/north-korea-nuclear-collapse-1.4636292",
            "https://blogs.dropbox.com/tech/2018/04/4696/",
            "https://www.amazon.com/dp/B077JFK5YH/",
            "https://amuletplatform.com/data/",
            "https://techblog.realtor.com/a-better-ecs/",
            "https://aws.amazon.com/chime/",
            "http://gothamist.com/2018/04/26/gothamist_self_aware_jday.php",
            "https://soundcloud.com/theaipodcast/fusion",
            "https://openfip.github.io/redfi/",
            "https://spring.io/blog/2018/04/25/spring-tips-spring-statemachine",
            "https://blogs.oracle.com/java/javafx-webview-overview",
            "https://venturebeat.com/2018/04/22/hire-ground-how-fetchers-using-ai-to-help-companies-headhunt-the-best-candidates/",
            "https://www.matheus.ro/2017/09/26/design-patterns-and-practices-in-net-option-functional-type-in-csharp/",
            "https://sleekdb.github.io/",
            "http://www.ecliptik.org",
            "https://www.mapd.com/blog/speed-at-scale-how-general-purpose-gpus-can-save-us-from-data-overload/",
            "https://www.vice.com/en_us/article/4w4kg3/the-totalitarian-buddhist-who-beat-sim-city",
            "https://gab41.lab41.org/pyseal-homomorphic-encryption-in-a-user-friendly-python-package-e27547a0b62f",
            "https://trifinlabs.com/consumer-software/",
            "https://hanxiao.github.io/2018/04/21/Teach-Machine-to-Comprehend-Text-and-Answer-Question-with-Tensorflow/",
            "https://medicalxpress.com/news/2018-04-complicated-biology-garlic.html",
            "https://github.com/gaul/java-collection-overhead",
            "https://medium.com/@JustFixNYC/building-eviction-free-nyc-with-gatsbyjs-contentful-a0308bfcb866",
            "http://nautil.us/issue/24/error/the-data-that-threatened-to-break-physics",
            "https://www.youtube.com/watch?v=QkcBASKLyeU",
            "http://xn--ls8h.st/react.html",
            "https://www.digitimes.com/news/a20180425PD205.html",
            "https://arstechnica.com/gaming/2018/04/behind-the-scenes-with-the-hackers-who-unlocked-the-nintendo-switch/",
            "https://rumorsontheinternets.org/2010/10/14/magnasanti-the-largest-and-most-terrifying-simcity/",
            "https://cs.uwaterloo.ca/~watrous/TQI/",
            "https://www.linuxfoundation.org/press-release/41-organizations-join-the-linux-foundation-to-support-open-source-communities-with-infrastructure-and-resources/",
            "http://www.lihaoyi.com/post/HowToDriveChangeasaSoftwareEngineer.html",
            "https://cloudplatform.googleblog.com/2018/04/Exploring-container-security-Running-a-tight-ship-with-Kubernetes-Engine-1-10.html",
            "https://slate.com/business/2018/04/kirsten-gillibrands-ambitious-postal-banking-bill.html",
            "https://www.youtube.com/watch?v=NKmGVE85GUU",
            "https://www.zdnet.com/article/how-to-make-the-most-of-the-new-gmail/",
            "https://www.snap.com/en-US/news/post/new-spectacles-made-for-summer/",
            "https://www.criptonoticias.com/mineria/aduana-venezolana-confisca-prohibe-importacion-equipos-mineria-bitcoin/",
            "http://blog.manypixels.co/the-anatomy-of-a-productized-service/",
            "https://www.lifefaker.com/?latest",
            "https://www.imaginarycloud.com/blog/what-is-art/",
            "https://sysprogs.com/w/turning-the-cypress-super-speed-explorer-kit-into-a-continuous-200mss-logic-analyzer/",
            "https://medium.com/@AnnikaHelendi/serverless-survey-77-delivery-speed-4-dev-workdays-mo-saved-26-aws-monthly-bill-d99174f70663",
            "https://blog.kontena.io/locking-down-kubernetes-workers/",
            "http://www.sciencemag.org/news/2018/04/your-behavior-starbucks-may-reveal-more-about-you-you-think",
            "https://www.androidpolice.com/2018/04/26/smartphone-addiction-worth-talking-probably-isnt-social-crisis/",
            "http://www.latimes.com/science/sciencenow/la-sci-sn-galaxy-mega-merger-20180425-story.html",
            "https://github.com/maxamel/SpringZKAuth",
            "http://style.org/ku/",
            "http://thesoundingline.com/visualizing-global-population-growth-by-continent/",
            "http://git-awards.com/",
            "https://www.washingtonpost.com/news/the-switch/wp/2018/04/26/facial-recognition-may-be-coming-to-a-police-body-camera-near-you/",
            "http://www.bbc.com/news/technology-43907248",
            "https://apnews.com/3fdfdc9a06f54fa3bbca30af030e7d3b/European-Space-Agency-releases-1st-image-from-Mars-orbiter",
            "https://medium.com/@pavisj/convolutions-and-backpropagations-46026a8f5d2c",
            "https://www.youtube.com/watch?v=BMHUKij1yUE",
            "http://semantic-domain.blogspot.com/2018/04/are-functional-programs-easier-to.html"
    )

    var timestamp = 1524779416733L
    for (url in history) {
        awesomeBar.load(url, Date(timestamp), url.contains("java") || url.contains("growth"))
        timestamp += 5000
    }

    val query = readLine()
    val results = awesomeBar.search(query!!)
    for (result in results) {
        println(result.score.toString() + " " + result.url)
    }
}