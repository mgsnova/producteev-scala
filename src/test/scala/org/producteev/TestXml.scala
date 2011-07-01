package org.producteev

object TestXml {
  val dashboardList = """<?xml version="1.0" encoding="ISO-8859-1"?>
    <dashboards>
      <node>
        <dashboard>
          <id_dashboard>243972</id_dashboard>
          <id_creator>106531</id_creator>
          <title>privat</title>
          <write_ok>1</write_ok>
          <time_lastchange>Wed, 11 May 2011 21:06:39 +0200</time_lastchange>
          <status>1</status>
          <deleted>0</deleted>
          <smart_labels>0</smart_labels>
          <needs_upgrade>0</needs_upgrade>
          <accesslist>
            <node>
              <user>
                <id_user>106531</id_user>
                <firstname>first</firstname>
                <lastname>last</lastname>
                <company/>
                <email>mail@web.de</email>
                <timezone>Europe/Berlin</timezone>
                <time_signup>Wed, 11 May 2011 20:57:15 +0200</time_signup>
                <lang>1</lang>
                <avatar>http://producteev.com//static/images/default-avatar.jpg</avatar>
                <deleted>0</deleted>
                <default_dashboard>243972</default_dashboard>
                <sort_by>4</sort_by>
                <facebooks/>
                <colleagues/>
                <dashboard_status>1</dashboard_status>
              </user>
            </node>
          </accesslist>
        </dashboard>
      </node>
      <node>
        <dashboard>
          <id_dashboard>250322</id_dashboard>
          <id_creator>106531</id_creator>
          <title>second</title>
          <write_ok>1</write_ok>
          <time_lastchange>Wed, 25 May 2011 21:21:34 +0200</time_lastchange>
          <status>1</status>
          <deleted>0</deleted>
          <smart_labels>0</smart_labels>
          <needs_upgrade>0</needs_upgrade>
          <accesslist>
            <node>
              <user>
                <id_user>106531</id_user>
                <firstname>first</firstname>
                <lastname>last</lastname>
                <company/>
                <email>mail@web.de</email>
                <timezone>Europe/Berlin</timezone>
                <time_signup>Wed, 11 May 2011 20:57:15 +0200</time_signup>
                <lang>1</lang>
                <avatar>http://producteev.com//static/images/default-avatar.jpg</avatar>
                <deleted>0</deleted>
                <default_dashboard>243972</default_dashboard>
                <sort_by>4</sort_by>
                <facebooks/>
                <colleagues/>
                <dashboard_status>1</dashboard_status>
              </user>
            </node>
          </accesslist>
        </dashboard>
      </node>
    </dashboards>"""

  val dummy = """<tag>foo</tag>"""

  val time = """<?xml version="1.0" encoding="ISO-8859-1"?>
    <time>
      <value>Mon, 23 May 2011 16:22:41 -0400</value>
    </time>"""

  val userLogin = """<login>
       <token>a_session_token</token>
       <email>user@provider.com</email>
    </login>"""

  val userView = """<?xml version="1.0" encoding="ISO-8859-1"?>
    <user>
      <id_user>106531</id_user>
      <firstname>first</firstname>
      <lastname>last</lastname>
      <company>co</company>
      <email>mail@web.de</email>
      <timezone>Europe/Berlin</timezone>
      <time_signup>Wed, 11 May 2011 20:57:15 +0200</time_signup>
      <lang>1</lang>
      <avatar>http://producteev.com//static/images/default-avatar.jpg</avatar>
      <deleted>0</deleted>
      <default_dashboard>243972</default_dashboard>
      <sort_by>4</sort_by>
      <facebooks/>
      <colleagues/>
    </user>"""

  val userListItem = """<?xml version="1.0" encoding="ISO-8859-1"?>
    <node>
      <user>
        <id_user>106531</id_user>
        <firstname>first</firstname>
        <lastname>last</lastname>
        <company>co</company>
        <email>mail@web.de</email>
        <timezone>Europe/Berlin</timezone>
        <time_signup>Wed, 11 May 2011 20:57:15 +0200</time_signup>
        <lang>1</lang>
        <avatar>http://producteev.com//static/images/default-avatar.jpg</avatar>
        <deleted>0</deleted>
        <default_dashboard>243972</default_dashboard>
        <sort_by>4</sort_by>
        <facebooks/>
        <colleagues/>
        <dashboard_status>1</dashboard_status>
      </user>
    </node>"""

  val dashboardView = """<?xml version="1.0" encoding="ISO-8859-1"?>
    <dashboard>
      <id_dashboard>250322</id_dashboard>
      <id_creator>106531</id_creator>
      <title>second</title>
      <write_ok>1</write_ok>
      <time_lastchange>Wed, 25 May 2011 21:21:34 +0200</time_lastchange>
      <status>1</status>
      <deleted>0</deleted>
      <smart_labels>0</smart_labels>
      <needs_upgrade>0</needs_upgrade>
      <accesslist>
        <node>
          <user>
            <id_user>106531</id_user>
            <firstname>first</firstname>
            <lastname>last</lastname>
            <company/>
            <email>mail@web.de</email>
            <timezone>Europe/Berlin</timezone>
            <time_signup>Wed, 11 May 2011 20:57:15 +0200</time_signup>
            <lang>1</lang>
            <avatar>http://producteev.com//static/images/default-avatar.jpg</avatar>
            <deleted>0</deleted>
            <default_dashboard>243972</default_dashboard>
            <sort_by>4</sort_by>
            <facebooks/>
            <colleagues/>
            <dashboard_status>1</dashboard_status>
          </user>
        </node>
      </accesslist>
    </dashboard>"""

  val dashboardListItem = """<?xml version="1.0" encoding="ISO-8859-1"?>
    <node>
      <dashboard>
        <id_dashboard>250322</id_dashboard>
        <id_creator>106531</id_creator>
        <title>second</title>
        <write_ok>1</write_ok>
        <time_lastchange>Wed, 25 May 2011 21:21:34 +0200</time_lastchange>
        <status>1</status>
        <deleted>0</deleted>
        <smart_labels>0</smart_labels>
        <needs_upgrade>0</needs_upgrade>
        <accesslist>
          <node>
            <user>
              <id_user>106531</id_user>
              <firstname>first</firstname>
              <lastname>last</lastname>
              <company/>
              <email>mail@web.de</email>
              <timezone>Europe/Berlin</timezone>
              <time_signup>Wed, 11 May 2011 20:57:15 +0200</time_signup>
              <lang>1</lang>
              <avatar>http://producteev.com//static/images/default-avatar.jpg</avatar>
              <deleted>0</deleted>
              <default_dashboard>243972</default_dashboard>
              <sort_by>4</sort_by>
              <facebooks/>
              <colleagues/>
              <dashboard_status>1</dashboard_status>
            </user>
          </node>
        </accesslist>
      </dashboard>
    </node>"""

  val statsSuccess = """<stats>
      <result>TRUE</result>
    </stats>"""

  val statsFailure = """<stats>
      <result>FALSE</result>
    </stats>"""

  val labelList = """<labels>
      <node>
        <label>
          <id_label>323451</id_label>
          <id_creator>206530</id_creator>
          <id_dashboard>243972</id_dashboard>
          <title>foo</title>
          <color>#6D763E</color>
          <type>1</type>
          <x></x>
          <y></y>
          <order></order>
          <time_create>Wed, 11 May 2011 21:04:20 +0200</time_create>
          <time_lastchange>Wed, 11 May 2011 21:04:20 +0200</time_lastchange>
          <from></from>
          <deleted>0</deleted>
          <order_position></order_position>
        </label>
      </node>
      <node>
        <label>
          <id_label>323452</id_label>
          <id_creator>206530</id_creator>
          <id_dashboard>243972</id_dashboard>
          <title>foo2</title>
          <color>#6D763E</color>
          <type>1</type>
          <x></x>
          <y></y>
          <order></order>
          <time_create>Wed, 11 May 2011 21:04:20 +0200</time_create>
          <time_lastchange>Wed, 11 May 2011 21:04:20 +0200</time_lastchange>
          <from></from>
          <deleted>0</deleted>
          <order_position></order_position>
        </label>
      </node>
    </labels>"""

  val noteList = """<notes>
      <node>
        <note>
          <id_note>1856485</id_note>
          <id_task_ext>3254284</id_task_ext>
          <id_creator>106536</id_creator>
          <message>yes</message>
          <file_url/>
          <file_name/>
          <time_create>Sat, 25 Jun 2011 16:40:11 +0200</time_create>
          <time_lastchange>Sat, 26 Jun 2011 16:40:11 +0200</time_lastchange>
          <deleted>0</deleted>
        </note>
      </node>
      <node>
        <note>
          <id_note>1856486</id_note>
          <id_task_ext>3254284</id_task_ext>
          <id_creator>106536</id_creator>
          <message>no</message>
          <file_url/>
          <file_name/>
          <time_create>Sat, 25 Jun 2011 16:40:11 +0200</time_create>
          <time_lastchange>Sat, 26 Jun 2011 16:40:11 +0200</time_lastchange>
          <deleted>0</deleted>
        </note>
      </node>
    </notes>"""

  val taskView = """<task>
      <id_task>2377422</id_task>
      <id_dashboard>143972</id_dashboard>
      <id_creator>126530</id_creator>
      <id_responsible>106530</id_responsible>
      <assign_by></assign_by>
      <time_created>Wed, 11 May 2011 21:06:50 +0200</time_created>
      <title>blafasel</title>
      <status>1</status>
      <star>0</star>
      <vote>0</vote>
      <deadline></deadline>
      <all_day>-1</all_day>
      <reminder>0</reminder>
      <repeating_interval></repeating_interval>
      <repeating_value>1</repeating_value>
      <hot>0</hot>
      <progression>0</progression>
      <public>0</public>
      <uid_lastchange>106530</uid_lastchange>
      <time_lastchange>Wed, 11 May 2011 21:06:50 +0200</time_lastchange>
      <from>0</from>
      <time_status></time_status>
      <r>1</r>
      <w>1</w>
      <x>1</x>
      <d>1</d>
      <viewed>1</viewed>
      <deleted>0</deleted>
      <nb_note>0</nb_note>
      <nb_new_note>0</nb_new_note>
      """ + labelList + """
      """ + noteList + """
    </task>"""

  val taskListItem = """<node><task>
      <id_task>2377422</id_task>
      <id_dashboard>143972</id_dashboard>
      <id_creator>126530</id_creator>
      <id_responsible>106530</id_responsible>
      <assign_by></assign_by>
      <time_created>Wed, 11 May 2011 21:06:50 +0200</time_created>
      <title>blafasel</title>
      <status>1</status>
      <star>0</star>
      <vote>0</vote>
      <deadline></deadline>
      <all_day>-1</all_day>
      <reminder>0</reminder>
      <repeating_interval></repeating_interval>
      <repeating_value>1</repeating_value>
      <hot>0</hot>
      <progression>0</progression>
      <public>0</public>
      <uid_lastchange>106530</uid_lastchange>
      <time_lastchange>Wed, 11 May 2011 21:06:50 +0200</time_lastchange>
      <from>0</from>
      <time_status></time_status>
      <r>1</r>
      <w>1</w>
      <x>1</x>
      <d>1</d>
      <viewed>1</viewed>
      <deleted>0</deleted>
      <nb_note>0</nb_note>
      <nb_new_note>0</nb_new_note>
      <labels></labels>
      <notes></notes>
    </task></node>"""

  val taskList = """<tasks>
    <node><task>
      <id_task>2377422</id_task>
      <id_dashboard>143972</id_dashboard>
      <id_creator>126530</id_creator>
      <id_responsible>106530</id_responsible>
      <assign_by></assign_by>
      <time_created>Wed, 11 May 2011 21:06:50 +0200</time_created>
      <title>blafasel</title>
      <status>1</status>
      <star>0</star>
      <vote>0</vote>
      <deadline></deadline>
      <all_day>-1</all_day>
      <reminder>0</reminder>
      <repeating_interval></repeating_interval>
      <repeating_value>1</repeating_value>
      <hot>0</hot>
      <progression>0</progression>
      <public>0</public>
      <uid_lastchange>106530</uid_lastchange>
      <time_lastchange>Wed, 11 May 2011 21:06:50 +0200</time_lastchange>
      <from>0</from>
      <time_status></time_status>
      <r>1</r>
      <w>1</w>
      <x>1</x>
      <d>1</d>
      <viewed>1</viewed>
      <deleted>0</deleted>
      <nb_note>0</nb_note>
      <nb_new_note>0</nb_new_note>
      <labels></labels>
      <notes></notes>
    </task></node>
    <node><task>
      <id_task>2377423</id_task>
      <id_dashboard>143972</id_dashboard>
      <id_creator>126530</id_creator>
      <id_responsible>106530</id_responsible>
      <assign_by></assign_by>
      <time_created>Wed, 11 May 2011 21:06:50 +0200</time_created>
      <title>blafasel2</title>
      <status>1</status>
      <star>0</star>
      <vote>0</vote>
      <deadline></deadline>
      <all_day>-1</all_day>
      <reminder>0</reminder>
      <repeating_interval></repeating_interval>
      <repeating_value>1</repeating_value>
      <hot>0</hot>
      <progression>0</progression>
      <public>0</public>
      <uid_lastchange>106530</uid_lastchange>
      <time_lastchange>Wed, 11 May 2011 21:06:50 +0200</time_lastchange>
      <from>0</from>
      <time_status></time_status>
      <r>1</r>
      <w>1</w>
      <x>1</x>
      <d>1</d>
      <viewed>1</viewed>
      <deleted>0</deleted>
      <nb_note>0</nb_note>
      <nb_new_note>0</nb_new_note>
      <labels></labels>
      <notes></notes>
    </task></node>
    </tasks>
  """

  val labelListItem = """<node>
      <label>
        <id_label>323451</id_label>
        <id_creator>206530</id_creator>
        <id_dashboard>243972</id_dashboard>
        <title>foo</title>
        <color>#6D763E</color>
        <type>1</type>
        <x/>
        <y/>
        <order/>
        <time_create>Wed, 11 May 2011 21:04:20 +0200</time_create>
        <time_lastchange>Wed, 11 May 2011 21:04:20 +0200</time_lastchange>
        <from/>
        <deleted>0</deleted>
        <order_position/>
      </label>
    </node>"""

  val labelView = """<label>
      <id_label>323451</id_label>
      <id_creator>206530</id_creator>
      <id_dashboard>243972</id_dashboard>
      <title>foo</title>
      <color>#6D763E</color>
      <type>1</type>
      <x/>
      <y/>
      <order/>
      <time_create>Wed, 11 May 2011 21:04:20 +0200</time_create>
      <time_lastchange>Wed, 11 May 2011 21:04:20 +0200</time_lastchange>
      <from/>
      <deleted>0</deleted>
      <order_position/>
    </label>"""

  val noteView = """<note>
      <id_note>1856485</id_note>
      <id_task_ext>3254284</id_task_ext>
      <id_creator>106536</id_creator>
      <message>yes</message>
      <file_url/>
      <file_name/>
      <time_create>Sat, 25 Jun 2011 16:40:11 +0200</time_create>
      <time_lastchange>Sat, 26 Jun 2011 16:40:11 +0200</time_lastchange>
      <deleted>0</deleted>
    </note>"""

  val noteListItem = """<node>
      <note>
        <id_note>1856485</id_note>
        <id_task_ext>3254284</id_task_ext>
        <id_creator>106536</id_creator>
        <message>yes</message>
        <file_url/>
        <file_name/>
        <time_create>Sat, 25 Jun 2011 16:40:11 +0200</time_create>
        <time_lastchange>Sat, 26 Jun 2011 16:40:11 +0200</time_lastchange>
        <deleted>0</deleted>
      </note>
    </node>"""
}
